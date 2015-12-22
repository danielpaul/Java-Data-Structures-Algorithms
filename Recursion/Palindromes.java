import java.util.Scanner;

public class Palindromes {

  public static void main(String args[]) 
  {
    Scanner scan = new Scanner(System.in);
    String word = scan.next();

    System.out.println(isPalindrome(word));
  }

  
  static boolean isPalindrome(String word) 
  {
    if(word.length() == 0 || word.length() == 1)
    {
      return true;
    }
    else if(word.charAt(0) == word.charAt(word.length() - 1)) 
    {
      return isPalindrome(word.substring(1, word.length() - 1));
    } 
    else 
    {
      return false;
    }
  }

}