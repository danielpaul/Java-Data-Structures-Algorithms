import java.util.*;

public class Char implements Comparable<Char> {

  char key;
  double frequency;

  public Char(char key) {
    this.key = key;
  }

  public Char(char key, int frequency) {
    this.key = key;
    this.frequency = (double) frequency;
  }

  public int compareTo(Char c) {
    return (int) (c.frequency - this.frequency); // descending order.
  }

}