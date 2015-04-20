public class thousands {

  public static void main(String args[]) {

    /* Tests */
    writeNum(12345678);
    System.out.println();

    writeNum(77);
    System.out.println();
    
    writeNum(12345);
    System.out.println();
    
    writeNum(1);
    System.out.println();
    
    writeNum(1345678901);
    System.out.println();

  }

  /* Recursive method writes an integer number formated with commas */
  public static void writeNum(int n) {

    // Condition to stop the recursion.
    if(n < 1000) {
      System.out.print(n);
      return;
    }

    writeNum(n / 1000);

    System.out.print("," + n % 1000);

  }

}