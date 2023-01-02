// Project 1
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;


public class Maze {
  
  private static char[][] mazeArray;
  
  
  
  public static char[][] getMaze(String filename) throws IOException {
    FileReader fr = new FileReader("samp.txt");
    BufferedReader br = new BufferedReader(fr);
    String line = br.readLine();
    String[] dimension = line.split(" ");
    int l = Integer.parseInt(dimension[0]);
    int w = Integer.parseInt(dimension[1]);
    char[][] mazeArray = new char[l][w];
    
    int i = 0;
    while ((line = br.readLine()) != null) {
      for (int j = 0; j < line.length(); j++) {
        mazeArray[i][j] = line.charAt(j);
      }
      i++;
    }
    
    for (int k = 0; k < mazeArray.length; k++) {
      for (int m = 0; m < mazeArray[k].length; m++) {
        System.out.print(mazeArray[k][m]);
      }
      System.out.println();
    }
    
    fr.close();
    br.close();
    
    return mazeArray;
  }
  public static int[] findEntry() {
    int[] entry = new int[2];
    for (int i = 0; i < mazeArray.length; i++) {
      for (int j = 0; j < mazeArray[i].length; j++) {
        if (mazeArray[i][j] == '+') {
          entry[0] = i;
          entry[1] = j;
        }
      }
    }
    return entry;
  }
  public static int[] findExit() {
    int[] exit = new int[2];
    for (int i = 0; i < mazeArray.length; i++) {
      for (int j = 0; j < mazeArray[i].length; j++) {
        if (mazeArray[i][j] == '-') {
          exit[0] = i;
          exit[1] = j;
        }
      }
    }
    return exit;
  }
  public static boolean isValidSpot(char[][] mazeArray, int r, int c) {
    return mazeArray[r][c] == ' ';
  }
  
  public static boolean traverse(char[][] mazeArray, int x, int y, int[] exit) {
    ArrayList<int[]> fringe = new ArrayList<>();
    fringe.add(new int[]{x, y});
    ArrayList<int[]> explored = new ArrayList<>();
    
    while (!fringe.isEmpty()) {
      int[] current = fringe.remove(0);
      int r = current[0];
      int c = current[1];
      if (!explored.contains(current)) {
        if (Arrays.equals(current, exit)) {
          return true;
          
        }
        
        if (isValidSpot(mazeArray, r - 1, c)) fringe.add(new int[]{r - 1, c});
        if (isValidSpot(mazeArray, r + 1, c)) fringe.add(new int[]{r + 1, c});
        if (isValidSpot(mazeArray, r, c - 1)) fringe.add(new int[]{r, c - 1});
        if (isValidSpot(mazeArray, r, c + 1)) fringe.add(new int[]{r, c + 1});
        explored.add(current);
        mazeArray[r][c] = '+';
      }
    }
    return false;
  }
  
  public static void main(String[] args) throws IOException {
    
    mazeArray = getMaze("samp.txt");
    int[]entry = findEntry();
    int[]exit = findExit();
    
    System.out.println(Arrays.toString(entry));
    System.out.println(Arrays.toString(exit));
    
    if(traverse(mazeArray, 0, 0, exit)) {
      System.out.println("Solved maze.");
    }
    else {
      System.out.println("Could not solve maze.");
    }
    
  }
  
}
