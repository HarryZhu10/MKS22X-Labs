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



}







}
