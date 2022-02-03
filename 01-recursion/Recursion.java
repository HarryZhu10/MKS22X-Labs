public class Recursion {
  /*Print all words that are made of the letters a-e inclusive.
         *@param length : the length of the words that are to be printed
         */
         public static void printAllWords(int length){
           //printAllWords(length,"");
           char[] letters = {'a', 'b', 'c', 'd'};
           printNoDoubleLetterWords(3, letters);
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
          char[] letters = {'a', 'b', 'c', 'd'};
           printNoDoubleLetterWords(3, letters);
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

        }
