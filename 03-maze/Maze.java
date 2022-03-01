import java.util.*;
          import java.io.*;
          public class Maze{
            private char[][]maze;
            private boolean animate;//false by default
            private int startRow,startCol;

            /*Constructor loads a maze text file, and sets animate to false by default.
            When the file is not found then:
            throw a FileNotFoundException

            You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
            '#' - Walls - locations that cannot be moved onto
            ' ' - Empty Space - locations that can be moved onto
            'E' - the location of the goal if any (0 or more per file)
            'S' - the location of the start(exactly 1 per file)

            You may also assume the maze has a border of '#' around the edges.
            So you don't have to check for out of bounds!
            Some text editors always include a newline at the end of a file, but that is not always present.
            Make sure your file reading is able to handle this.
            */



            public static char[][] fileRead (String file) throws FileNotFoundException{
                File text = new File(file);
                Scanner in = new Scanner(text);
                ArrayList<String> store = new ArrayList<String>();

                    while (in.hasNext()) {
            store.add(in.nextLine());
                    }


                    char[][] newStore = new char[store.size()][(store.get(0)).length()];


                    for (int i = 0; i < store.size(); i ++) {
                      for (int x = 0; x < store.get(0).length(); x ++) {
                        newStore[i][x] = (store.get(i)).charAt(x);

                      }
                    }

                  return newStore;

            }

            public static String findStart (String file) throws FileNotFoundException {
              char[][] check = fileRead(file);
              String position = "";
              for (int i = 0; i < check.length; i ++) {
                for (int x = 0; x < check[i].length; x ++) {
                  if (check[i][x] == 'S') {
                    position = position + i + x;
                  }
                }
              }
              return position;
            }



            public Maze(String filename) throws FileNotFoundException{
              //COMPLETE CONSTRUCTOR
                maze = fileRead(filename);
                animate = false;
                startRow = Integer.parseInt(findStart(filename).substring(0));
                startCol = Integer.parseInt(findStart(filename).substring(1));


            }

            private void wait(int millis){
              try {
                Thread.sleep(millis);
              }
              catch (InterruptedException e) {
              }
            }

            public void setAnimate(boolean b){
              animate = b;
            }

            public static void clearTerminal(){
              //erase terminal
              System.out.println("\033[2J");
            }
            public static void gotoTop(){
              //go to top left of screen
              System.out.println("\033[1;1H");
            }

            /*Return the string that represents the maze.
            It should look like the text file with some characters replaced.
            */


            // ASK WHICH CHARACTERS ARE SUPPOSED TO BE REPLACED







            public String toString(){
              String combine = "";
              for (int x = 0; x < maze.length; x ++){
                for (int y = 0; y < maze[0].length; y ++){
                  combine += maze[x][y];
                }
                if (x != maze.length - 1){
                  combine += "\n";
                }
              }
              return combine;
            }

            /*Wrapper Solve Function returns the helper function
            Note the helper function has the same name, but different parameters.
            Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
            */
            public int solve(){
              //only clear the terminal if you are running animation
              if(animate){
                clearTerminal();
              }
              //start solving at the location of the s.
              return solve(startRow,startCol);

            }

            /*
            Recursive Solve function:

            A solved maze has a path marked with '@' from S to E.

            Returns the number of @ symbols from S to E when the maze is solved,
            Returns -1 when the maze has no solution.

            Postcondition:
            The 'S' is replaced with '@'
            The 'E' remain the same
            All visited spots that were not part of the solution are changed to '.'
            All visited spots that are part of the solution are changed to '@'
            */
            private int solve(int row, int col){ //you can add more parameters since this is private
              //automatic animation! You are welcome.
              if(animate){
                gotoTop();
                System.out.println(this);
                wait(50);
              }

              if (maze[row][col] == 'E') {

              } else {
                
              }


              //COMPLETE SOLVE
              return -1; //so it compiles
            }
          }
