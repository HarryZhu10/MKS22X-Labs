import java.util.*;
import java.io.*;

public class Silver {
  public static long solve(String filename) throws FileNotFoundException{
    File text = new File(filename);
    Scanner in = new Scanner(text);
    char[][] pasture = new char[in.nextInt()][in.nextInt()];
    int time = in.nextInt();

    for (int i = 0; i < pasture.length; i ++) {
      String val = in.nextLine();
      for (int x = 0; x < val.length(); x ++) {
        pasture[i][x] = val.charAt(x);
      }
      }

      



    }


public static void main(String[] args) {
  try{
System.out.println(solve("ctravel.txt"));
  } catch (FileNotFoundException e) {
    System.out.println("" + -1);
  }
}
  }
