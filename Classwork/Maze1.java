import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Maze1 {


//read ary first and then allocate the stuff

  public static void main(String[] args) {

  }

  public static char[][] pasteToAry (String file) throws FileNotFoundException{
    File text = new File(file);
    Scanner in = new Scanner(text);

        int row = 0;
        int col = 0;

        while (in.hasNext()) {
          col ++;

        }

        while (in.hasNextLine()) {
          row ++;
        }

        char[][] store = new char[row][col];

while (in.hasNextLine()) {
String line = in.nextLine();
        for (int i = 0; i < store.length; i ++) {
          for (int x = 0; x < line.length(); x ++) {
            store[i][x] = line.charAt(x);
            if (x == store[i].length - 1) {
              store[i][x] += '\n';
            }
          }
        }
      }
      return store;
}
}
