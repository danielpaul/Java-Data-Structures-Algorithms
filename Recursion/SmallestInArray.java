import java.util.*;

public class SmallestInArray {

  public static void main(String args[]) 
  {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter the length of the array: ");
    int size = scan.nextInt();

    int[] numbers = new int[size];
    for(int i = 0; i < numbers.length; i++)
    {
      System.out.print("Number at numbers[" + i + "] = ");
      numbers[i] = scan.nextInt();
    }

    int smallest = smallest(numbers);
    System.out.println("Smallest number in array: " + smallest);
  }

  public static int smallest(int[] numbers) 
  {
    if(numbers.length == 1)
    {
      return numbers[0];
    }
    else
    {
      int firstNumber = numbers[0];
      int[] newArray = Arrays.copyOfRange(numbers, 1, numbers.length);
      int newSmall = smallest(newArray);
      return Math.min(firstNumber, newSmall);
    }
  }

}