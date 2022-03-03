public class MazeGenerator {
//you still need to check if the space have fewer than 2 open neighbors
public static boolean safeCarve (char[][]maze, int row, int col) {
  return row != 0 && row != maze.length - 1 && col != 0 && col != maze[row].length - 1;
}


public static void generate(char[][]maze, int startrow, int startcol) {
for (int i = 0; i < maze.length; i ++) {
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
