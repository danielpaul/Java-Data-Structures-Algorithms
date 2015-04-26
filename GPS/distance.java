/* Find distance between two GPS locations. */

public class distance {

  public static void main(String[] args) {

    double[] a = {53.3807, -6.594596000000024}; // Maynooth University.
    double[] b = {40.6892494, -74.0445004}; // Statue of Liberty.

    double distance = getDistance(a, b);

    System.out.println("Distance between point a (" + a[0] + "," + a[1] + ") and b (" + b[0] + "," + b[1] + ") is " + distance + "km.");

  }

  public static double getDistance(double[] a, double[] b) {

    final int r = 6371; // Radius of the earth.

    double h = haversin(Math.toRadians(b[0] - a[0])) + (Math.cos(a[0]) * Math.cos(b[0]) * haversin(Math.toRadians(b[1] - a[1])));
    double d = 2 * r * Math.asin(Math.sqrt(h));

    return (haversin(d/r) * 10000) / 0.62137; // Convert to Km before return.
  }

  public static double haversin(double rad) {
    return (1 - Math.cos(rad)) / 2;
  }

}