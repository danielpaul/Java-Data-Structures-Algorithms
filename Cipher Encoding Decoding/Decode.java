import java.util.*;

public class Decode {

  static String[] inputs; // variable to store the message.
  static ArrayList<Char> characters = new ArrayList<Char>(); // Store all the unique char in encoded message.

  public static void main(String args[]) {

    FileIO reader = new FileIO();
    inputs = reader.load("encoded.txt");

    Map<Character,Double> encoded = new HashMap<Character,Double>();
    int total_chars = 0;

    for(String line : inputs) {
      for(char c : line.toCharArray()) {
        total_chars++;
        if(encoded.containsKey(c)) {
          encoded.put(c, encoded.get(c) + 1);
        } else {
          encoded.put(c, 1.0);
        }
      }
    }


    // Find probability of all keys and add to char list.
    for(char c : encoded.keySet()) {
      // System.out.println(key + " " + encoded.get(key));
      Char key = new Char(c);
      key.frequency = encoded.get(c);
      characters.add(key);
    }

    Collections.sort(characters);


    for(Char c : characters) {
      System.out.println(c.key + " " + c.frequency);
    }

    decodeInput();

    printMessage();

  }

  static void decodeInput() {
    // Languages to test encoded text with.
    String[] languages = {"danish","english","finnish","french","german","icelandic","polish","russian","spanish","swedish"};

    ArrayList<Language> tests = new ArrayList<Language>();
    for(String l : languages) tests.add(new Language(l));

    for(int l = 0; l < tests.size(); l++) {
      Language ln = tests.get(l);

      double score = 0.0;
      
      for(int i = 0; i < 26; i++) {
        score += characters.get(i).frequency - ln.characters.get(i).frequency;
      }

      ln.matchScore = score;
    }

    Collections.sort(tests);

    
    for(Language l : tests) {
      System.out.println(l.name + " " + l.matchScore);
    }


    ArrayList<Char> decodeChars = tests.get(0).characters;


    for(int i = 0; i < inputs.length; i++) {
      for(int j = 0; j < inputs[i].length(); j++) {

        char c = inputs[i].charAt(j);
        int charIndex = indexOfChar(c);

        if(charIndex != -1 && charIndex < decodeChars.size()) {
          char replaceWith = decodeChars.get(charIndex).key;

          // Custom overwites of guessed punctuation.
          // if(replaceWith == 'x') replaceWith = '.';

          inputs[i] = inputs[i].substring(0, j) + replaceWith + inputs[i].substring(j + 1);
        }
      }
    }

  }

  static int indexOfChar(char ch) {
    int index = 0;
    for(Char c : characters) {
      if(c.key == ch) return index;
      index++;
    }
    return -1;
  }

  static void printMessage() {
    for(int i = 0; i < inputs.length; i++) System.out.println(inputs[i]);
  }

}
