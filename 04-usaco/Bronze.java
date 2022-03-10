public class Bronze {

public static long solve(String filename) {
  File text = new File(filename);
  Scanner in = new Scanner(text);
  char [][] pasture = new char [in.nextInt()][in.nextInt()];
  int elevation = in.nextInt();
  int instructionAmount = in.nextInt();
  for (int i = 0; i < pasture.length; i ++) {
    for (int x = 0; x < pasture[i].length; x ++) {
      pasture[i][x] = in.nextInt();
    }
  }

  ArrayList<String> instructions = new ArrayList<String>();
  while (in.hasNextLine()) {
    instructions.add(in.nextLine());
  }

while (instructions.size() > 0) {
  String ins = instructions.remove(0);
  stomp(ins.substring(0, 1), ins.substring(1, 2), ins.substring(2), pasture);
}

}


public static void stomp (int row, int col, int stompAmount, char[][] pasture) {
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


}



}
