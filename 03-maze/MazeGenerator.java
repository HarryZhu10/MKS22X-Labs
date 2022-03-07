public class MazeGenerator {
//you still need to check if the space have fewer than 2 open neighbors

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


public static boolean safeCarve (char[][]maze, int row, int col) {
      return row != 0 && row != maze.length - 1 && col != 0 && col != maze[row].length - 1 && maze[row][col] !=  ' ' && openNeighbors(maze, row, col) < 2;
}


public static void carveGenerate(char[][]maze, int row, int col) {
  if (safeCarve(maze, startrow, startcol) == true) {
    maze[row][col] = ' ';
    Random random = new Random();
    int randDirection = random.nextInt(4);

    if (randDirection == 0) {
      carveGenerate(maze, row + 1, col);
    }

    if (randDirection == 1) {
      carveGenerate(maze, row - 1, col);
    }

    if (randDirection == 2) {
      carveGenerate(maze, row, col + 1);
    }

    if (randDirection == 3) {
      carveGenerate(maze, row, col - 1);
    }
  }



}



}
