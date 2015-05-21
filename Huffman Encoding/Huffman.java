import java.util.*;

public class Huffman {

  public static void main(String args[]) {

    Scanner scan = new Scanner(System.in);
    System.out.print("\nEnter a word to encode: ");
    String word = scan.nextLine();
    System.out.println();

    String original = "", encoded = "";

    int[] counter = new int[word.length()]; // Each position is for the letter in the position in the word.

    for(char c : word.toCharArray()) {
      String ASCII_code = Integer.toBinaryString((int) c);
      if(ASCII_code.length() == 6) ASCII_code = "0" + ASCII_code; // Make to 7 chars long.
      
      original += ASCII_code + " ";
      counter[word.indexOf(c)]++; // Count the number of times this character appears.
    }

    System.out.println(original + "\n");


    // Priority queue of trees
    PriorityQueue<Tree> PQ = new PriorityQueue<Tree>();

    // Go through each unique chars in our sentence.
    for(int i = 0; i < counter.length; i++) {

      if(counter[i] != 0) {
        // Print number of times each char appeared.
        System.out.println("'" + word.charAt(i) + "' appeared " + counter[i] + " time" + ((counter[i] > 1) ? "s" : ""));

        // Create a tree with one node and add to priority queue.
        PQ.add(Tree.growTree(counter[i], word.charAt(i))); // Create a new tree with frequency and char.
      }

    }

    // Huffman's algorithm.
    while(PQ.size() > 1) { // While there are two or more Trees left in the priority queue.
      // System.out.println(PQ.poll().root.letter);

      // Choose two of the lowest frequency trees and create a new tree with each one as nodes.
      Tree appleTree = PQ.poll();
      Tree mangoTree = PQ.poll();

      int totalFrequency = appleTree.frequency + mangoTree.frequency;
      Tree newTree = Tree.growTree(totalFrequency, appleTree, mangoTree); // Create a new tree linking both trees.

      PQ.add(newTree);
    }


    // Only one Tree left. 
    Tree HuffmanTree = PQ.poll();

    System.out.println();

    // Go through each char and find the new encoded code.
    for(char c : word.toCharArray()) {
      encoded += HuffmanTree.getCode(c) + " ";
    }

    System.out.println(encoded + "\n");


    double original_bits = countBits(original);
    double encoded_bits = countBits(encoded);
    double compressed = Math.round((encoded_bits / original_bits) * 10000) / 100.00;

    System.out.println("Compressed size is " + (int) encoded_bits + " bits / " + (int) original_bits + " bits = " + compressed + "%\n");

  }

  /* Find bits (excluding space char) */
  public static double countBits(String sentence) {
    int count = sentence.length();
    for(char c : sentence.toCharArray()) {
      if(c == ' ') count--; // Decrement from string length count if space is found.
    }
    return (double) count;
  }


}