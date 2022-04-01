import java.io.*;
import java.util.*;

public class Calculator{

      /*Evaluate a postfix expression stored in s.
       *Assume valid postfix notation, of ints doubles and operators separated by spaces.
       *Valid operators are + - / * and % (remainder not modulo)
       *All results are doubles even if the operands are both int.
       *@throws IllegalArgumentException when there are too many or too few operands.
       *        Use the string parameter of your exception to indicate what happened.
       */

      public static double eval(String s){
        if (s.length() == 0) {
          throw new IllegalArgumentException("Too few operands");
        }
        Scanner in = new Scanner(s);
        Deque<Double> storage = new ArrayDeque<Double>();
        while (in.hasNext()) {
          if (in.hasNextInt() || in.hasNextDouble()) {
            storage.addLast(Double.parseDouble(in.next()));
          } else {
            if (storage.size() < 2) {
              throw new IllegalArgumentException("Too few operands");
            }
            operator(in.next(), storage);
          }
        }
        if (storage.size() > 1) {
          throw new IllegalArgumentException("Too few operators");
        }

        return storage.getFirst();
      }



      public static void operator (String operator, Deque<Double> stack) {
        double a =  stack.removeLast();
        double b =  stack.removeLast();

        if (operator.equals("+")) {
          stack.addLast(b + a);
        }

        if (operator.equals("-")) {
          stack.addLast(b - a);
        }

        if (operator.equals("*")) {
          stack.addLast(b * a);
        }

        if (operator.equals("/")) {
          stack.addLast(b / a);
        }

        if (operator.equals("%")) {
          stack.addLast(b % a);
        }
      }

public static void main(String[] args) {
  /*
  System.out.println(eval("4 /"));
  System.out.println(eval("11 3 - 4 + 2.5 *"));
  System.out.println(eval("10 2.0 +"));
  System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
  System.out.println(eval("1 2 3 4 5 + * - -"));

*/
System.out.println(eval(""));
//System.out.println(eval("5"));
}
  }
