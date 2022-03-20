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



int r1 = in.nextInt() - 1;
int c1 = in.nextInt() - 1;
int r2 = in.nextInt() - 1;
int c2 = in.nextInt() - 1;
/*
pasture[r1][c1] = '@';
evenPasture[r1][c1] = 1;
while (time >= 0) {
  for (int i = 0; i < pasture.length; i ++) {
    for (int x = 0; x < pasture[i].length; x ++) {
      if (pasture[i][x] == '@') {
        if (even) {
          wander(i, x, evenPasture, oddPasture, pasture);
        } else {
          wander(i, x, oddPasture, evenPasture, pasture);
        }
      }
    }
  }
  System.out.println(toString(evenPasture));
  System.out.println(toString(oddPasture));

  even = !even;
  time --;
}


if (time % 2 == 0) {
  System.out.println("" + evenPasture[r2][c2]);
  return (long) evenPasture[r2][c2];
} else {
  System.out.println("" + oddPasture[r2][c2]);
  return (long) oddPasture[r2][c2];
}
*/
} catch (FileNotFoundException e) {
  return -1;
}

    }


public static void wander (int row, int col, int[][] pasture, int[][] oppositePasture, char[][] charPasture) {
    if (row + 1 < pasture.length && oppositePasture[row + 1][col] != -1 ) {
      pasture[row][col] += oppositePasture[row + 1][col];
      charPasture[row + 1][col] = '@';
    }

    if (row - 1 >= 0 && oppositePasture[row - 1][col] != -1) {
      pasture[row][col] += oppositePasture[row - 1][col];
      charPasture[row - 1][col] = '@';
    }

    if (col + 1 < pasture[row].length && oppositePasture[row][col + 1] != -1) {
      pasture[row][col] += oppositePasture[row][col + 1];
      charPasture[row][col + 1] = '@';
    }

    if ( col - 1 >= 0 && oppositePasture[row][col - 1] != -1) {
      pasture[row][col] += oppositePasture[row][col - 1];
      charPasture[row][col - 1] = '@';
    }
}


public static String toString (int[][] arr) {
  String result = "";
  for (int i = 0; i < arr.length; i ++) {
    for (int x = 0; x < arr[i].length; x ++) {
      result += arr[i][x] + " ";
    }
        result += "\n";
    }
    return result;
}

public static String toString (char[][] arr) {
  String result = "";
  for (int i = 0; i < arr.length; i ++) {
    for (int x = 0; x < arr[i].length; x ++) {
      result += arr[i][x] + " ";
    }
    result += "\n";
    }
    return result;
}


public static void insertVal (int[][] arr, char[][] arr1) {
  for (int i = 0; i < arr.length; i ++) {
    for (int x = 0; x < arr[i].length; x ++) {
      if (arr1[i][x] == '*') {
        arr[i][x] = -1;
      }
    }
}

}


public static void main(String[] args) {

System.out.println(solve("ctravel.2.in"));

  }
}
