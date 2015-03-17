/* Program asks user for letters they have and finds the longest possible words that can be made with those letters. */

import java.util.*;

class FindWords {

  public static void main(String args[]) {

    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the letters you have: ");
    String letters = scan.next().toLowerCase(); // Chnage to lowercase to match exact words.

    FileIO reader = new FileIO();
    String[] dictionary = reader.load("dictionary.txt"); // Reading the File as a String array.

    // Array list to store all the possible words that can be made.
    ArrayList<String> possibleWords = new ArrayList<String>();
    int longestPossibleWord = 1;

    // Loop through each word in dictionary and check if that word can be formed with our letters.
    for(int i = 0; i < dictionary.length; i++) {
      String word = dictionary[i];
      if(canFormWord(letters, word)) { // If we can form this word with our letters.
        if(word.length() >= longestPossibleWord) { // If longer than the longest possible word we have so far, add it to the list.
          longestPossibleWord = word.length();
          possibleWords.add(word);
        }
      }
    }

    System.out.println("\nThe longest word that can be formed is one with " + longestPossibleWord + " letters:");

    // Loop through possible words and print the largest possible words.
    for (int i = 0; i < possibleWords.size(); i++) {
      String word = possibleWords.get(i);
      if(word.length() == longestPossibleWord) System.out.println(word);
    }
  }

  /* Method checks if the passed in word can be formed with the letters we have. */
  public static boolean canFormWord(String letters, String word) {

    // Foreach char check if that letter exists, if it does remove from letter string as we have used them.
    for(char c : word.toCharArray()) {
      int charIndex = letters.indexOf(c);
      if(charIndex == -1) return false; // If not found, the word can't be formed.
      letters = letters.substring(0, charIndex) + letters.substring(charIndex + 1);
    }

    return true; // Making this word is possible with the set of letters we have.
  }

}