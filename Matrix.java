import java.util.Hashtable;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Matrix {

  public static double matrixMultiply(double matrixOne [][], double matrixTwo [][]) {
    double result [][] = new double[matrixOne.length][matrixTwo[0].length];
    for (int i = 0; i < matrixOne.length; i++) {
      for (int j = 0; j < matrixTwo[0].length; j++) {
          for (int k = 0; k < matrixOne[0].length; k++) {
              result[i][j] += matrixOne[i][k] * matrixTwo[k][j];
              
          }
      }
  }
  return result[1][1];
  }

  public static void graphMode() {
    System.out.println("Graph mode");
    Hashtable<Integer, Long> timings = new Hashtable<Integer, Long>();
    // loop 100 times
    // for each loop, create a matrix of size i, multiply it, and record the time
    for (int i = 2; i < 100; i++) {
      // Create matrix of size matrixSize and populate it with random numbers
      double  matrixOne [][] = new double[i][i];
      double  matrixTwo [][] = new double[i][i];
      Random rand = new Random();
      for (int j = 0; j < i; j++) {
        for (int k = 0; k < i; k++) {
          matrixOne[j][k] = rand.nextDouble();
          matrixTwo[j][k] = rand.nextDouble();
        }
      }
      long startTime = System.nanoTime();
      double toPrint = matrixMultiply(matrixOne, matrixTwo);
      long endTime = System.nanoTime();
      long duration = (endTime - startTime);
      System.out.println("Time taken: " + duration + " nanoseconds");
      timings.put(i, duration);
    }
    // save the dictionary to a file using csv format
    try {
      File myObj = new File("graphPlots.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    FileWriter rewrite;
    try {
      rewrite = new FileWriter("graphPlots.txt");
      rewrite.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    for (int p = 2; p < 100; p++) {
      try {
      FileWriter myWriter = new FileWriter("graphPlots.txt", true);
      myWriter.append(Integer.toString(p));
      myWriter.append(",");
      myWriter.append(Long.toString(timings.get(p).intValue()));
      myWriter.append("\n");
      // System.out.println("Successfully wrote " + Long.toString(timings.get(p)) + " to the file");
      myWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }

  }

  public static void main(String args[]) {

    int matrixSize;

    // Check if arguments are given
    if (args.length == 0) {
      System.out.println("No arguments given. Using default size of 2.");
      matrixSize = 2;
    }
    // Check if args are "graph"
    else if (args[0].equals("graph")) {
      graphMode();
    }
    else {
      matrixSize = Integer.parseInt(args[0]);
    

    
    // Create matrix of size matrixSize and populate it with random numbers
    double  matrixOne [][] = new double[matrixSize][matrixSize];
    double  matrixTwo [][] = new double[matrixSize][matrixSize];
    Random rand = new Random();
    for (int i = 0; i < matrixSize; i++) {
      for (int j = 0; j < matrixSize; j++) {
        matrixOne[i][j] = rand.nextDouble();
        matrixTwo[i][j] = rand.nextDouble();
      }
    }


    double firstarray[][] = {{1, 2, -2, 0}, {-3, 4, 7, 2}, {6, 0, 3, 1}};
    double secondarray[][] = {{-1, 3}, {0, 9}, {1, -11}, {4, -5}};


    /* Create another 2d array to store the result using the original arrays' lengths on row and column respectively. */
    double [][] result = new double[firstarray.length][secondarray[0].length];


    /* Loop through each and get product, then sum up and store the value */
    for (int i = 0; i < firstarray.length; i++) {
        for (int j = 0; j < secondarray[0].length; j++) {
            for (int k = 0; k < firstarray[0].length; k++) {
                result[i][j] += firstarray[i][k] * secondarray[k][j];
            }
        }
    }

    


    /* Show the result */

    // System.out.println(result[p][q]);
    // System.out.println(result[1][1]);
    long startTime = System.nanoTime();
    double toPrint = matrixMultiply(matrixOne, matrixTwo);
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);
    System.out.println("Time taken: " + duration + " nanoseconds");


  }

}
}
