/* Travelling Salesman Problem. Program finds the shortest route possible covering all the towns. */

import java.io.*;
import java.util.*;

public class tsp {

  static double[][] distances;

  public static void main(String args[]) {

    /* Variables to store data. */
    ArrayList<Town> towns = new ArrayList<Town>();

    /* Read all towns and store in data structure. */
    try {
      File file = new File("1000airports.txt");
      FileReader fileReader = new FileReader(file);
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      String line;

      while ((line = bufferedReader.readLine()) != null) {

        // Get the data from each line.
        String[] data = line.split(",");

        int id = Integer.parseInt(data[0]) - 1; // Minus one as IDs start from 1. Plus 1 while printing.
        String name = data[1];
        double x = Double.parseDouble(data[2]);
        double y = Double.parseDouble(data[3]);

        // Store all the data as an object and store in arrayList.
        Town newTown = new Town(id, name, x, y);
        towns.add(newTown);

      }

      fileReader.close();

    } catch (IOException e) {
      e.printStackTrace();
    }


    /* Find the distance between all the towns. Store results in a 2D array for reuse. */
    distances = new double[towns.size()][towns.size()];

    for(Town a : towns) {
      for(Town b : towns) {

        if(a.id == b.id) { // If a & b are the same town.
          distances[a.id][b.id] = 0;
          continue;
        }

        // Find and store the distance between towns.
        distances[a.id][b.id] = a.distanceTo(b);
      }
    }



    /* Calculate all the possible solutions for the shortest route. */

    double bestDistance = 0.0;
    String bestSquence = "";


    // For selecting starting point. Try everything as a starting point.
    for(Town t : towns) {

      /* Copy town's arrayList and use it to remove visited towns. */
      ArrayList<Town> toVisit = new ArrayList<Town>(towns);
      removeTown(t.id, toVisit); // Remove the starting town.

      /* Nearest neighbour algorithm. */

      double totalDistance = 0.0;
      String visitSequence = (t.id + 1) + ""; // Save the visiting sequence as a string.

      int currentTownID = t.id;
      while(!toVisit.isEmpty()) { // Till we have visited all the towns.

        int nearestTownID = nearestTown(currentTownID, toVisit);

        visitSequence += "." + (nearestTownID + 1); // Add to sequence. Plus 1 to get actual ID.
        totalDistance += distances[currentTownID][nearestTownID]; // Add the distance visited.

        removeTown(nearestTownID, toVisit); // Visit the nearest town.
        currentTownID = nearestTownID; // We are now in that town.
      }


      // If first time OR if current result is better.
      if(bestDistance == 0.0 || totalDistance < bestDistance) {
        bestDistance = totalDistance;
        bestSquence = visitSequence;
      }

      // System.out.println("Starting town: " + t.name + ". Travelled Distance: " + totalDistance);

    }

    System.out.println("\n\nBest sequence with total distance of " + bestDistance + ":\n\n" + bestSquence);

  }


  /* Method to remove a town from ArrayList<Town>. */
  private static void removeTown(int town_id, ArrayList<Town> towns) {

    // Go through each item in the list till we find the town and remove.
    for(int i = 0; i < towns.size(); i++) {
      Town current = towns.get(i);
      
      if(current.id == town_id) { // Found the town.
        towns.remove(i); // Remove from the same array that was passed.
        break;
      }

    }
  }


  /* Method to find the nearest town from a list of towns that are available to visit. */
  private static int nearestTown(int town_id, ArrayList<Town> canVisit) {
    int nearestTownID = town_id;
    double nearestDistance = 0.0;

    for(int i = 0; i < distances[town_id].length; i++) {
      if(distances[town_id][i] == 0.0) continue; // Skip comparing with same town.

      // Skip if town ID is not in the list of town that we can visit.
      if(!hasTown(i, canVisit)) continue; // Cannot visit this town.

      // If no value for nearest distance, set this town to be the nearest. (Runs first time).
      if(nearestDistance == 0.0) {
        nearestTownID = i;
        nearestDistance = distances[town_id][i];
        continue;
      }

      // Check if current town's distance is shorter.
      if(distances[town_id][i] < nearestDistance) {
        nearestTownID = i;
        nearestDistance = distances[town_id][i];
      }
    }

    return nearestTownID;
  }


  /* Method to check if a town is in ArrayList<Town>. */
  private static boolean hasTown(int town_id, ArrayList<Town> towns) {

    // Go through each item in the list till we find the town.
    for(Town t : towns) {
      if(t.id == town_id) { // Found the town.
        return true; // Return true.
      }
    }

    return false; // Assume that we don't have the town.
  }


  /* Method to print out 2D array of doubles. */
  public static void printDistances(double[][] array) {
    for (double[] arr : array) {
      System.out.println(Arrays.toString(arr));
    }
  }

}