import java.util.*;
public class MazeGenerator {

public static int openNeighbors(char[][]maze, int row, int col) {
  int sum = 0;
  if (maze[row][col + 1] == ' ') {
    sum ++;
  }

  if (maze[row][col - 1] == ' ') {
    sum ++;
  }

  if (maze[row + 1][col] == ' ') {
    sum ++;
  }

  if (maze[row - 1][col] == ' ') {
    sum ++;
  }
  return sum;
}


public static boolean safeCarve (char[][] maze, int row, int col) {
      return row != 0 && row != maze.length - 1 && col != 0 && col != maze[row].length - 1 && maze[row][col] !=  ' ' && openNeighbors(maze, row, col) < 2;
}


public static void carveGenerate(char[][] maze, int row, int col) {
  if (safeCarve(maze, row, col) == true) {
    maze[row][col] = ' ';

    ArrayList<String> dir = new ArrayList<String>();
    dir.add("N");
    dir.add("S");

    dir.add("E");
    dir.add("W");

    Collections.shuffle(dir);

    for (int i = 0; i < dir.size(); i ++) {

        if (dir.get(i) == "N") {
            carveGenerate(maze, row + 1, col);
        }

        if (dir.get(i) == "E") {
            carveGenerate(maze, row, col - 1);
        }

        if (dir.get(i) == "S") {
            carveGenerate(maze, row - 1, col);
        }

        if (dir.get(i) == "W") {
            carveGenerate(maze, row, col + 1);
        }
    }
  }
}

public static void generate(char[][]maze, int startrow, int startcol) {
  carveGenerate(maze, startrow, startcol);
  boolean placeE = true;
  maze[startrow][startcol] = 'S';


  while (placeE) {
    Random random = new Random();
    int col = random.nextInt(maze[0].length - 2) + 1;
    int row = random.nextInt(maze.length - 2) + 1;
    if ((row != startrow || col != startcol) && Math.max(maze.length, maze[0].length) - 3 <= Math.abs(row - startrow) + Math.abs(col - startcol)) {
      if (maze[row][col] == ' ') {
        maze[row][col] = 'E';
        placeE = false;
      }
    }
  }
}

public static String toString (char[][] text) {
  String result = "";
  for (int i = 0; i < text.length; i ++) {
    for (int x = 0; x < text[i].length; x ++) {
      result += text[i][x];
      if (x == text[i].length - 1) {
        result += "\n";
      }
    }
  }
  return result;
}

}
