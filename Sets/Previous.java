import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Previous {
  public static void main(String [] args) {

    Scanner scan = new Scanner(System.in);
    HashSet<Integer> numbers = new HashSet<Integer>();

    System.out.print("Enter numbers: "); // 45 8 20 7 16 45 0 22 20 6 20 9 -1

    int num = scan.nextInt();
    System.out.print("\nPrevious: ");
    while(num != -1) {
      if(!numbers.add(num)) {
        System.out.print(num + " ");
      }
      num = scan.nextInt();
    }

        

  }
}