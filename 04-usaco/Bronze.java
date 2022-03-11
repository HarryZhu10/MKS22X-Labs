import java.util.*;
import java.io.*;

public class Bronze {

public static long solve(String filename) throws FileNotFoundException{
  File text = new File(filename);
  Scanner in = new Scanner(text);
  int [][] pasture = new int [in.nextInt()][in.nextInt()];
  int elevation = in.nextInt();
  int instructionAmount = in.nextInt();
  for (int i = 0; i < pasture.length; i ++) {
    for (int x = 0; x < pasture[i].length; x ++) {
      pasture[i][x] = in.nextInt();
    }
  }


while (in.hasNextInt()) {
  int row = in.nextInt();
  int col = in.nextInt();
  int stompAmount = in.nextInt();
  stomp(row, col, stompAmount, pasture);
}

for (int i = 0; i < pasture.length; i ++) {
  for (int x = 0; x < pasture[i].length; x ++) {
    if (elevation - pasture[i][x] <= 0) {
      pasture[i][x] = -1;
    } else {
      pasture[i][x] = elevation - pasture[i][x];
    }
  }
}

int aggregatedDepth = 0;
for (int i = 0; i < pasture.length; i ++) {
  for (int x = 0; x < pasture[i].length; x ++) {
    if (pasture[i][x] != -1) {
      aggregatedDepth += pasture[i][x];
    }
  }
}


 long volume = aggregatedDepth * 72 * 72;
 return volume;
}


public static void stomp (int row, int col, int stompAmount, int[][] pasture) {
  int max = 0;
  for (int i = row - 1; i < pasture.length && i < row + 2; i ++) {
    for (int x = col - 1; x < pasture[i].length && x < col + 2; x ++) {
      if (pasture[i][x] > max) {
        max = pasture[i][x];
      }
    }
  }


int targetAmount = max - stompAmount;


for (int i = row - 1; i < pasture.length && i < row + 2; i ++) {
  for (int x = col - 1; x < pasture[i].length && x < col + 2; x ++) {
    if (pasture[i][x] > targetAmount) {
      pasture[i][x] = targetAmount;
    }
  }
}

}


public static void main(String[] args) {
    try{
  System.out.println(solve("makelake.txt"));
} catch (FileNotFoundException e){
System.out.println("" + -1);
}

}



}
