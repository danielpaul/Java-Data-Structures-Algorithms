import java.io.*;
import java.util.Scanner;

public class FourStarsFilter {

  public static void main(String args[]) {

    try {
      File file = new File("jazz.txt");
      Scanner input = new Scanner(file);

      File output_file = new File("fourstar.txt");
      output_file.createNewFile();
      FileWriter writer = new FileWriter(output_file);

      while (input.hasNextLine()) {
        String line = input.nextLine();

        String[] splitted_by_space = line.split(" ");
        String stars = splitted_by_space[0];

        int stars_count = stars.length();
        if(stars_count == 4) {
          writer.write(line + "\n");
          System.out.println(line);
        }

      }

      writer.flush();
      writer.close();

      input.close();

    } catch (Exception ex) {
      System.out.println("File not found.");
    }

  }

}
