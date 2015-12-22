import java.util.*;

public class EvenOdder
{
  public static void main(String args[])
  {
    Scanner scan = new Scanner(System.in);

    List<Integer> odd = new ArrayList<Integer>();
    List<Integer> even = new ArrayList<Integer>();

    System.out.print("Enter numbers: ");
    int num = scan.nextInt();
    while(num != -1)
    {
      if(num % 2 == 0) 
        even.add(num);
      else
        odd.add(num);
      num = scan.nextInt();
    }

    System.out.print("\nOdd numbers: ");
    for(int i = 0; i < odd.size(); i++)
      System.out.print(odd.get(i) + " ");

    System.out.print("\nEven numbers: ");
    for(int i = 0; i < even.size(); i++)
      System.out.print(even.get(i) + " ");

  }
}