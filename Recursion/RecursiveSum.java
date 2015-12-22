import java.util.Scanner;

public class RecursiveSum {

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    int start = scan.nextInt();
    int end = scan.nextInt();

    System.out.println(sum(start, end));
  }

  
  static int sum(int start, int end) {
    // Just to visualise how variables are changing on each recursive call.
    System.out.println("Start: " + start + ", End: " + end);
    
    if(start == end) return start;
    return start + sum(start + 1, end);
  }

}