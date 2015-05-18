public class bits {


/*
  
  - Java int is represnted as 32 bits.
  - Starting from the right, each bit represents increasing powers of 2.
  - The leftmost bit is special. It is negative, and represents -2^31, which is -2,147,483,647.
  - The effective range is therefore from 2,147,483,646 to -2,147,483,647.


  Bit Representation:
    * 0 = 00000000 00000000 00000000 00000000
    * -1 = 11111111 11111111 11111111 11111111
    * -2 = 11111111 11111111 11111111 11111110
    * 65535 = 00000000 00000000 11111111 11111111
    * -65535 = 11111111 11111111 00000000 00000001


*/



  public static void operators() {

    /* ---------- Bitwise Operators: ---------- */

    /*
      &
        bitwise AND
          The bits in the result are set to 1 where the corresponding bits in the two operands are both 1, the other bits are set to 0.

          0001 = 1
        & 0011 = 3
         ------
          0001 = 1
    */
    System.out.println("& bitwise AND: 1 & 3: " + (1 & 3));


    /*
      |
        bitwise inclusive OR
          The bits in the result are set to 1 where at least one of the corresponding bits in the two operands is , the other bits are set to 0.

          0001 = 1
        | 0011 = 3
         ------
          0011 = 3
    */
    System.out.println("| bitwise inclusive OR: 1 | 3: " + (1 | 3));


    /*
      ^
        bitwise exclusive OR
          The bits in the result are set to 1 where the corresponding bits in the two operands are different, the other bits (where the corresponding bits in the two operands are the same are set to 0)
    
          0001 = 1
        ^ 0011 = 3
         ------
          0010 = 2
    */
    System.out.println("^ bitwise exclusive OR: 1 ^ 3: " + (1 ^ 3));


    /*
      <<
        left shift
          Shifts the bits of the first operand left by the number of bits specified by the second operand; fill from the right with 0.

          1 << 2 = 4
          0001 << 0010 = 0100 
    */
    System.out.println("<< left shift: 1 << 2: " + (1 << 2));


     /*
      <<
        signed right shift
          Shifts the bits of the first operand right by the number of bits specified by the second operand. If the first operand is negative, 1s are filled in from the left; otherwise, 0s are filled in from the left.

          8 >> 2 = 2
          01000 >> 00010 = 0010

          -8 >> 2 = -2
          11..111000 >> 00...0010 = 1111...11110
    */
    System.out.println(">> signed right shift: 8 >> 2: " + (8 >> 2));
    System.out.println(">> signed right shift: -8 >> 2: " + (-8 >> 2));

    /*
      >>>
        unsigned right shift
          Shifts the bits of the first operand right by the number of bits specified by the second operand; 0s are filled in from the left.
          
          8 >>> 2 = 2
          00..01000 >> 000..0010 = 000..00010

          -8 >>> 2 = -2
          11..111000 >> 00...0010 = 00111...11110

    */
    System.out.println(">>> unsigned right shift: 8 >>> 2: " + (8 >>> 2));
    System.out.println(">>> unsigned right shift: -8 >>> 2: " + (-8 >>> 2));


    /*
      ~
        bitwise complement
          All 0 bits are set to 1, and all 1 bits are set to 0.

          ~5 = -6
          ~00..00101 = 11..11010
    */
    System.out.println("~ bitwise complement: ~5: " + (~5));
  }



  public static void main(String args[]) {
    
    operators();

  }


}