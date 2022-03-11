import java.util.*;
import java.io.*;

public class Silver {
  public static long solve(String filename) throws FileNotFoundException{
    File text = new File(filename);
    Scanner in = new Scanner(text);
    int row = in.nextInt();
    int col = in.nextInt();
    char[][] pasture = new char[row][col];
    int time = in.nextInt();
    int[][] evenPasture = new int[row][col];
    int[][] oddPasture = new int[row][col];


    for (int i = 0; i < pasture.length; i ++) {
      String val = in.nextLine();
      for (int x = 0; x < val.length(); x ++) {
        pasture[i][x] = val.charAt(x);
      }
      }


int r1 = in.nextInt();
int c1 = in.nextInt();
int r2 = in.nextInt();
int c2 = in.nextInt();



    }

public static void (int row, int col, pasture)


public static void main(String[] args) {
  try{
System.out.println(solve("ctravel.txt"));
  } catch (FileNotFoundException e) {
    System.out.println("" + -1);
  }
}
  }
