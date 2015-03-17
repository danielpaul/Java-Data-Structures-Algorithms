import java.util.*;

public class Language implements Comparable<Language> {

  String name = "";
  ArrayList<Char> characters = new ArrayList<Char>();

  double matchScore;

  public Language(String name) {
    this.name = name;

    FileIO reader = new FileIO();
    String[] inputs = reader.load("monograms/" + name + ".txt");

    // Add space and give it the highest priority.
    characters.add(new Char(' ', 100));

    getFrequencies(inputs);
    Collections.sort(characters);

    // printChars();
  }

  void getFrequencies(String inputs[]) {
    for(String line : inputs) {
      line = line.replaceAll("\\s","");

      char letter = line.charAt(0);
      Char key = new Char(letter);

      key.frequency = Double.parseDouble(line.substring(2));

      characters.add(key);
    }
  }

  void printChars() {
    for(Char c : characters) {
      System.out.println(c.key + " " + c.frequency);
    }
  }


  public int compareTo(Language l) {
    return (int) ((int) l.matchScore - (int) this.matchScore); // descending order.
  }

}