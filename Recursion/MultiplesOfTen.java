public class MultiplesOfTen {

  public static void main(String args[]) {

    int[] array = new int[] {3,4,6,25,40};

    boolean result = findMulipleTen(array, 0);

    System.out.println(result);
  }

  public static boolean findMulipleTen(int [] array, int start_index) {
    if(start_index < array.length) {
      int find_number = array[start_index] * 10;

      if(findIt(array, find_number, start_index + 1))
        return true;
      else
        return findMulipleTen(array, start_index + 1);
    }

    return false;
  }

  public static boolean findIt(int [] findIn, int number, int index) {
    if(index < findIn.length) {
      if(findIn[index] == number)
        return true;
      else
        return findIt(findIn, number, index + 1);
    }
    return false;
  }

}
