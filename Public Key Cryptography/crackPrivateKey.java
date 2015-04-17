public class crackPrivateKey {

  public static void main(String args[]) {

    /* Public key */
    long p = 24852977l;
    long g = 2744l;
    long gxmp = 8414508l; // g^x mod p

    /* Cipher */
    long cipher1 = 15268076l; // g^y mod p
    long cipher2 = 743675;  // m . (g^x)^y mod p

    /* Brute force to find private key */
    boolean found = false; long x = 0l;
    for(long i = 0l; !found; i++) {
      if(modPow(g, i, p) == gxmp) {
        found = true;
        x = i;
      }
    }
    System.out.println("Private key: " + x);

    /* Decode message */
    long c1 = modPow(cipher1, p - 1 - x, p);
    long message = modMult(c1, cipher2, p);
    System.out.println("Encrypted message: " + message);

  }

  public static long modPow(long number, long power, long modulus) {
    if(power == 0) return 1;
    
    if(power % 2 == 0) {
      long halfpower = modPow(number, power/2, modulus);
      return modMult(halfpower, halfpower, modulus);
    }

    long halfpower = modPow(number, power/2, modulus);
    long firstbit = modMult(halfpower, halfpower, modulus);
    return modMult(firstbit, number, modulus);
 }

 public static long modMult(long first, long second, long modulus) {
  if(second == 0) return 0;

  if(second % 2 == 0) {
    long half = modMult(first, second/2, modulus);
    return (half + half) % modulus;
  }

  long half = modMult(first, second/2, modulus);
  return (half + half + first) % modulus;
 }

}