public class Test{
  public static void main(String[] args){
    int size = 500;
    int n = 100;

    if(args.length > 1){
      size = Integer.parseInt(args[0]);
      n = Integer.parseInt(args[1]);
    }

    System.out.println("5% to 95% density every 5% intervals, BOARDSIZE OF " + size + ", " + n + " REPETITIONS");
    for (int i = 5; i <= 95; i += 5) {
      double ans = averageofNRuns(size, n, (double) i / 100);
      System.out.println("Density: " + i + ", Burn Time: " + ans);
    }

    System.out.println("55% to 65% density every 1% intervals, BOARDSIZE OF " + size + ", " + n + " REPETITIONS");
    for (int i = 55; i <= 65; i += 1) {
      double ans = averageofNRuns(size, n, (double) i / 100);
      System.out.println("Density: " + i + ", Burn Time: " + ans);
    }
  }

  public static double averageofNRuns (int size, int n, double density) {
    BurnTrees board;
    int total = 0;
    for (int i = 0; i < n; i ++) {
      board = new BurnTrees(size, size, density);
      total += board.run();
    }
    return total / n;
  }
}
