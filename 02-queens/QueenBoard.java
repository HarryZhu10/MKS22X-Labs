public class QueenBoard {
  private int[][] board;
  private int delay;
  private boolean animated;
  public QueenBoard (int size){
    board = new int [size][size];
    delay = 1000;
    animated = false;
  }
  public QueenBoard (int row, int col) {
    board = new int [row][col];
    delay = 1000;
    animated = false;
  }

  /**
           *@return The output string formatted as follows:
           *All numbers that represent queens are replaced with 'Q'
           *all others are displayed as underscores '_'
           *There are spaces between each symbol:
           *_ _ Q _
           *Q _ _ _
           *_ _ _ Q
           *_ Q _ _
           *excludes the characters up to the comment(*)
*/
           public String toString(){
             String result = "";
             for (int i = 0; i < board.length; i ++) {
               for (int x = 0; x < board[i].length; x ++) {

                 if (board[i][x] == -1) {
                   result += 'Q';
                 } else {
                   //use this version if you are working on your lab
                   result += board[i][x];


                  // result += '_';
                 }

                 if (x != board[i].length - 1) {
                   result += " ";
                 } else {
                   result += "\n";
                 }

               }

             }
             return result;
           }
           /**
             *@return true when the queen added correctly, false Otherwise
             *@precondition r and c are valid indices of the board array
             *@postcondition the board is only changed when the function returns true
             * in which case the queen is added and all it's threatened positions are incremented
             */
             public boolean addQueen(int r, int c){
               if (board[r][c] == 0) {
                 board[r][c] = -1;


                 for (int i = 1; r + i  < board.length; i ++) {
                   board[r + i][c] += 1;

                    if (c + i  < board[r + i].length) {
                      board[r + i][c + i] += 1;
                    }

                 }


                 for (int i = 1; r + i  < board.length && c - i  >= 0; i ++) {
                   board[r + i][c - i] += 1;
                 }


                 return true;
               } else {
                 return false;
               }
             }

             /**Remove the queen that was added to r,c
             *@precondition r and c are valid indices of the board array and there is a queen at position r,c
             *@postcondition the board is modified to remove that queen and all it's
             *threatened positions are decremented
             */
             public void removeQueen(int r, int c){
               if (board[r][c] == -1) {
                 board[r][c] ++;

                 for (int i = 1; r + i  < board.length; i ++) {
                   board[r + i][c] -= 1;

                    if (c + i  < board[r + i].length) {
                      board[r + i][c + i] -= 1;
                    }

                 }


                 for (int i = 1; r + i  < board.length && c - i  >= 0; i ++) {
                   board[r + i][c - i] -= 1;
                 }


               }
             }

             /**Find the first solution configuration possible for this size board. Start by placing
             *  the 1st queen in the top left corner, and each new queen in the next ROW. When backtracking
             *  move the previous queen to the next valid space. This means everyone will generate the same
             *  first solution.
             *@postcondition: the board remains in a solved state.
             *@return false when the board is not solveable and leaves the board filled with zeros;
             *        returns true when the board is solveable, and leaves the board in a solved state
             *@throws IllegalStateException when the board starts with any non-zero value (e.g. you solved a 2nd time.)
*/
             public boolean solve(){
               return solve(0);
               //check only here
             }

             public boolean solve (int row) {
               if (row >= board.length) {
                 return true;
               } else {
                 for (int i = 0; i < board[row].length; i ++) {
                   if (addQueen(row, i)) {
                     if(animated){
                       System.out.println(Text.go(1,1));
                       System.out.println(this);//can modify here
                       Text.wait(delay);
                     }

                     if (solve(row + 1)) {
                       return true;
                     }
                   }
                   removeQueen(row, i);
                   if(animated){
                     System.out.println(Text.go(1,1));
                     System.out.println(this);//can modify here
                     Text.wait(delay);
                   }

                 }
                 return false;
               }
             }

             public void setAnimate(boolean newValue) {
               animated = newValue;
             }

             public void setDelay(int newValue) {
               if (newValue < 0) {
               delay = 0;
             } else {
               delay = newValue;
             }
             }
             /*Find all possible solutions to this size board.
             *@return the number of solutions found, and leaves the board filled with only 0's
             *@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
*/
             public int countSolutions(int row){
               int counter = 0;
               if (row >= board.length) {
                counter ++;
               } else {
                 for (int i = 0; i < board[row].length; i ++) {
                   if (addQueen(row, i)) {

                       counter += countSolutions(row + 1);
                   }
                   removeQueen(row, i);

                 }

               }
               return counter;
             }

/*
             public int countSolutions () {

             }

*/

}
