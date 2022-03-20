import java.util.*;
import java.io.*;

public class Silver {

  public static long solve(String filename) {
    try {
    File text = new File(filename);
    Scanner in = new Scanner(text);
    int row = in.nextInt();
    int col = in.nextInt();
    int time = in.nextInt();
    String[] pasture = new String[row];

    for (int i = 0; i < row; i ++) {
            pasture[i] = in.next();
        }


        int r1 = in.nextInt();
        int c1 = in.nextInt();
        int r2 = in.nextInt();
        int c2 = in.nextInt();

        int [][][] allWays = new int [time + 1][row][col];
        allWays[0][r1 - 1][c1 - 1] = 1;


        int directionX[] = {0, 0, -1, 1};
        int directionY[] = {1, -1, 0, 0};

        for (int i = 1; i <= time; i ++) {
          for (int a = 0; a < row; a ++) {
            for (int b = 0; b < col; b ++) {
              for (int d = 0; d < 4; d ++) {
                  int r = a + directionX[d];
                  int c = b + directionY[d];
                  if (r >= 0 && c >= 0 && r < row && c < col && pasture[r].charAt(c) == '.') {
                      allWays[i][a][b] += allWays[i - 1][r][c];
                    }
                  }
                }
              }
            }
            return allWays[time][r2 - 1][c2 - 1];
          } catch (FileNotFoundException e) {
            return -1;
          }

        }





public static void main(String[] args) {

System.out.println(solve("ctravel.2.in"));

  }
}
