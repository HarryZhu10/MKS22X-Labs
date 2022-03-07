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


public static void generate(char[][]maze, int startrow, int startcol) {
  if (safeCarve(maze, startrow, startcol) == true) {
    //You have to check the open neighbors
  }


//for (int i = 0; i < maze.length; i ++) {
  for (int x = 0; x < maze[i].length; x ++) {
    if (startrow == i && startcol == x) {
      maze[i][x] = 'S';
    } else {
      maze[i][x] = '#';
    }
  }
}

}



}
