/* Town object to store cordinates and names of all the towns. */

public class Town {

  public final String name;
  public final int id;

  public final double x;
  public final double y;

  public Town(int id, String name, double x, double y) {
    this.id = id;
    this.name = name;
    this.x = x;
    this.y = y;
  }

  /* Method to find distance between two towns. */
  public double distanceTo(Town b) {

    final int R = 6371; // Radius of the earth

    Double latDistance = deg2rad(b.x - this.x);
    Double lonDistance = deg2rad(b.y - this.y);
    Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
            + Math.cos(deg2rad(this.x)) * Math.cos(deg2rad(b.x))
            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
    Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

    double distance = R * c * 1000; // convert to meters
    distance = Math.pow(distance, 2);

    return Math.sqrt(distance);
  }

  private double deg2rad(double deg) {
      return (deg * Math.PI / 180.0);
  }

}