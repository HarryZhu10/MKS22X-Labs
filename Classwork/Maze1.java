import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;


public class Maze1 {



  public static void main(String[] args) {
    try {
      Character[][] ary = pasteToAry("Maze1.txt");
      System.out.println(StringAry(ary));
} catch (FileNotFoundException e) {
}
}


public static Character[][] pasteToAry(String file)
throws FileNotFoundException{
    File text = new File(file);
    Scanner in = new Scanner(text);
    ArrayList<String> store = new ArrayList<String>();

        while (in.hasNext()) {
store.add(in.nextLine());
        }


        Character[][] newStore = new Character[store.size()][(store.get(0)).length()];


        for (int i = 0; i < store.size(); i ++) {
          for (int x = 0; x < store.get(0).length(); x ++) {
            newStore[i][x] = (store.get(i)).charAt(x);

          }
        }

      return newStore;

}

public static String StringAry (Character[][] text) {
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
