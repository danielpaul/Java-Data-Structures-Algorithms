import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Suspicious {
  public static void main(String [] args) {

    HashSet<String> names = new HashSet<String>();

    try {

      File file = new File(args[0]);
      Scanner scan = new Scanner(file);

      while (scan.hasNextLine()) {
        names.add(scan.nextLine());
      }

      file = new File(args[1]);
      scan = new Scanner(file);
      while(scan.hasNextLine()) {
        String name = scan.nextLine();
        if(!names.add(name)) {
          System.out.println(name);
        }
      }

      scan.close();
    } 
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }

  }
}