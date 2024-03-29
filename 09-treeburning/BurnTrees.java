import java.util.*;
public class BurnTrees{
  private int[][] map;
  private int ticks;
  private Deque<int[]> frontier;
  private int fireSize = 0;
  private int newSize = 0;
  private int treeSize = 0;
  private static final int TREE = 2;
  private static final int FIRE = 1;
  private static final int ASH = 3;
  private static final int SPACE = 0;


  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    //YOU MUST IMPLEMENT THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
    //HINT: do not check the board for fire which is an n^2 operation
    //if the size of your frontier is zero then it is done
    return frontier.size() == 0;//placeholder for compilation purposes
  }


  /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
   *All existing fires spread new fires, and turn to ash
   *new fires should remain fire, and not spread.
   */
  public void tick () {
  int originalSize = frontier.size();
  for (int i = 0; i < originalSize; i ++) {
    int[] coord = frontier.removeLast();
    int row = coord[0];
    int col = coord[1];
    checkDirection(row, col);
    map[row][col] = ASH;
  }

    ticks++;//leave this here.
    //YOU MUST IMPLEMENT THE REST OF THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
  }

  public boolean inBounds (int row, int col) {
    return row > -1 && row < map.length && col > -1 && col < map[row].length;
  }
  /***********************YOU MIGHT UPDATE THIS**************************/

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    for(int r=0; r<map.length; r++ ){
      for(int c=0; c<map[r].length; c++ ){
        if(Math.random() < density){
           map[r][c]=2;
         }
       }
     }
     frontier = new ArrayDeque<int[]>();
     start();//set the left column on fire.
  }


  public void checkDirection (int row, int col) {
    if (inBounds(row + 1, col) && map[row + 1][col] == TREE) {
      map[row + 1][col] = FIRE;
      int[] coord = {row + 1, col};
      frontier.addFirst(coord);
    }

    if (inBounds(row - 1, col) && map[row - 1][col] == TREE) {
      map[row - 1][col] = FIRE;
      int[] coord = {row - 1, col};
      frontier.addFirst(coord);
    }

    if (inBounds(row, col + 1) && map[row][col + 1] == TREE) {
      map[row][col + 1] = FIRE;
      int[] coord = {row, col + 1};
      frontier.addFirst(coord);
    }

    if (inBounds(row, col - 1) && map[row][col - 1] == TREE) {
      map[row][col - 1] = FIRE;
      int[] coord = {row, col - 1};
      frontier.addFirst(coord);
    }
  }


  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        map[i][0] = FIRE;
        int[] coord = {i, 0};
        frontier.addFirst(coord);
        fireSize ++;
      }
        if (map[i][1] == TREE) {
          int[] coord2 = {i, 1};
          frontier.addLast(coord2);
        }


      }
    }



    public static void main(String[]args){
      int WIDTH = 20;
      int HEIGHT = 20;
      int DELAY = 200;
      double DENSITY = .7;
      if(args.length > 1){
        WIDTH = Integer.parseInt(args[0]);
        HEIGHT = Integer.parseInt(args[1]);
        DENSITY = Double.parseDouble(args[2]);
      }
      if(args.length > 3){
        DELAY = Integer.parseInt(args[3]);
      }
      BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);


      int ans = b.animate(DELAY);//animate all screens
      System.out.println(ans);//print the final answer

      //int ans = b.outputAll();//print all screens one after another
      //System.out.println(ans);//print the final answer
    }




  /***********************DO NOT UPDATE THINGS BELOW HERE**************************/

  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }


  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }

  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==2)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==1)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==3)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }

  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }


}
