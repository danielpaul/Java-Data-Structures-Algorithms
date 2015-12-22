import java.util.Scanner;

public class Recurssion {
  
  
  public static void main(String args[]) {

    Scanner scan = new Scanner(System.in);
    char letter = scan.next().charAt(0);
    int count = scan.nextInt();

    for(int i = 0; i < count; i ++)
      System.out.print(letter);


    System.out.println("\nUsing Recurssion: ");

    printLetter(letter, count);

    String stringOfLetters = getLetterString(letter, count);
    System.out.println("\nString: \n" + stringOfLetters);

  }

  public static String getLetterString(char letter, int count) {
    if(count == 1) {
      return letter + "";
    } else {
      return letter + getLetterString(letter, count - 1);
    }
  }




 // FORGET ABOUT THIS!!!!!!!
  public static char printLetter(char letter, int count) {
    System.out.print(letter);
    if(count == 1) {
      return letter;
    } else {
      return printLetter(letter, count - 1);
    }
  }

}