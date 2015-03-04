import java.io.*;
import java.util.*;

public class Tree implements Comparable<Tree> {
 
  public Node root; // First node of the tree.
  public int frequency = 0;

  public Tree() {
    root = null; // No nodes in the tree yet.
  }

  // PriorityQueue needs to be able to somehow rank the objects in it.
  public int compareTo(Tree object) {
    if(frequency-object.frequency > 0) { //compare the cumulative frequencies of the tree.
      return 1;
    } else if(frequency-object.frequency < 0) {
      return -1; //return 1 or -1 depending on whether these frequencies are bigger or smaller.
    } else {
      return 0; //return 0 if they're the same.
    }
  }


  /* Get the path code for char. */
  String path = "";
  public String getCode(char letter) {
    path = ""; // Set path to none again for repeated run.
    return (findPath(this.root, letter)) ? path : "ERROR";
  }

  public boolean findPath(Node root, char letter) {

    if(root.letter == letter) return true; // Found the letter!

    if(root.leftChild != null && findPath(root.leftChild, letter)) {
      path = 0 + path;
      return true; // Pass true value back to the top!
    }

    if(root.rightChild != null && findPath(root.rightChild, letter)) {
      path = 1 + path;
      return true;
    }

    return false;
  }


  /* Method creates a new small tree with one node. */
  public static Tree growTree(int frequency, char letter) {
    Tree newTree = new Tree();
    newTree.frequency = frequency;

    newTree.root = new Node();
    newTree.root.letter = letter;

    return newTree;
  }

  /* Creates a new tree combining two trees */
  public static Tree growTree(int frequency, Tree one, Tree two) {
    Tree newTree = new Tree();
    newTree.frequency = frequency;

    newTree.root = new Node();

    // Check which node should go where.
    if(one.frequency > two.frequency) {
      newTree.root.leftChild = one.root;
      newTree.root.rightChild = two.root;
    } else {
      newTree.root.leftChild = two.root;
      newTree.root.rightChild = one.root;
    }

    return newTree;
  }


  


}