public class Recursion {
  /*Print all words that are made of the letters a-e inclusive.
         *@param length : the length of the words that are to be printed
         */
         public static void printAllWords(int length){
           printAllWords(length,"");
         }

         /*Print all words that are made of the letters a-e inclusive.
         *@param length : either how many more letters or the total length depending on implementation
         *@param word   : the partial word so far.
         */
        public static void printAllWords(int length,String word){
             if (length > 0) {
               for (char i = 'a'; i <= 'e'; i ++) {
                 printAllWords(length - 1, word + i);
               }
             } else {
               System.out.println(word);
             }
         }




        public static void main(String[] args) {
          // printAllWords(3, "");
        //  char[] letters = {'a', 'b', 'c', 'd'};
        //   printNoDoubleLetterWords(3, letters);
        //System.out.println(reverse("slack"));
        //  System.out.println(countNoDoubleLetterWords(2, ""));
        //  System.out.println(sqrt(49));
          System.out.println(fibIter(3, 1, 0));
        }




        /*Print all words that are made of the characters in the array of letters.
                *There may not be consecutive equal letters, so:
                *aax is not allowed, but axa is allowed.
                *@param length : the length of the words that are to be printed
                *@param letters: the letters you should be using
                */
        public static void printNoDoubleLetterWords(int length,char[] letters){
                  printNoDoubleLetterWords(length,"",letters);
                }

                /*Print all words that are made of the characters in letters. There may not be consecutive equal letters,
                *aax is not allowed, but axa is allowed.
                *@param length : either how many more letters need to be
                *@param word   : the partial word so far.
                *@param letters: the letters you should be using
                */
        public static void printNoDoubleLetterWords(int length,String word,char[]letters){
                  //WRITE THIS METHOD
                  if (length > 0) {
                    for (int i = 0; i < letters.length; i ++) {
                      if (word.length() < 2 || word.charAt(word.length() - 1) != word.charAt(word.length() - 2)) {
                      printNoDoubleLetterWords(length - 1, word + letters[i], letters);
                    }
                    }
                  } else {
                    if (word.charAt(word.length() - 1) != word.charAt(word.length() - 2)) {
                    System.out.println(word);
                  }
                }
                }



        public static String reverse(String s){
          if (!(s.equals(""))) {
            return s.substring(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
          } else {
            return "";
          }

        }


        /*@param length how long the words must be
          *param word the variable to store the partial solution (should start at "")
          *@return the number of words that have no adjacent matching letters using the letters a-z.
          *Repetition allowed except when letters are adjacent.
          */


         public static long countNoDoubleLetterWords(int length,String word){
            //Hint: not a wrapper method, but you must call it starting with "" as your word.

            //WRITE THIS METHOD
            long counter = 0;
            if (length > 0) {
              for (char i = 'a'; i <= 'z'; i ++) {
                if (word.length() == 0 || word.charAt(word.length() - 1) != i) {
                counter +=  countNoDoubleLetterWords(length - 1, word + i);
            }
            }
          } else {
                counter ++;
              }
              return counter;
            }


          /*
                    *@param n any non-negative value you want to take the sqrt of
                    *@return the approximate sqrt of n within a tolerance of 0.001%

                    public static double sqrt(double n){
                      //Hint: This is a wrapper method.
                      double guess = 1;
                      if (Math.abs((guess * guess - n) / n) * 100 > 0.001) {
                        guess = (n / guess + guess) / 2.0;
                        return sqrt(guess);
                      } else {
                      return guess;
                    }


                    }

*/

          /*
        *@param n any non-negative value
        *@return the nth term of the fibonacci sequence. 0, 1, 1, 2, 3, 5 etc.
*/
        public static int fibIter(int n, int f1, int f2){
          //DO NOT call fibIter more than once

          if (n > 1) {
            int save = f1;
            f1 = f1 + f2;
            f2 = save;
            return fibIter(n - 1, f1, f2);
          } else {
            return f1;
          }

        }


        }
