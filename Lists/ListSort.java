import java.util.*;

public class ListSort
{
  public static void main(String args[])
  {
    Scanner scan = new Scanner(System.in);

    List<Integer> list = new ArrayList<Integer>();

    System.out.print("Enter numbers: ");
    int num = scan.nextInt();
    while(num != -1)
    {
      list.add(num);
      num = scan.nextInt();
    }

    Collections.sort(list);
    System.out.print("\nSorted: ");
    for(int i : list)
      System.out.print(i + " ");
  }
}