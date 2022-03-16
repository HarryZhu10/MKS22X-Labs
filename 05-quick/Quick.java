import java.util.*;
public class Quick {

  public static int partition ( int [] data, int start, int end){
    Random rand = new Random();
    int pivotIndex = rand.nextInt(end - start + 1) + start;
    int p = data[pivotIndex];
    int[] ary = new int[end - start + 1];
    pivotIndex = 0;
    ary[pivotIndex] = p;
    int count = 1;

    for (int i = start; i < ary.length; i ++) {
        if (p > data[i]) {
          ary[pivotIndex + 1] = data[i];
          swap(ary, pivotIndex, pivotIndex + 1);
          pivotIndex ++;
        } else if (p < data[i]) {
          ary[ary.length - count] = data[i];
          count ++;
        } else {
          boolean on = true;

          while (i < ary.length && p == data[i]) {
            if (on) {
              ary[ary.length - count] = data[i];
              count ++;
            } else {
              ary[pivotIndex + 1] = data[i];
              swap(ary, pivotIndex, pivotIndex + 1);
              pivotIndex ++;
            }
            on = !on;
            i ++;
          }
        }

    }

return pivotIndex;

}




public static void swap (int[] data, int index1, int index2) {
  int x = data[index1];
  data[index1] = data[index2];
  data[index2] = x;
}

}
