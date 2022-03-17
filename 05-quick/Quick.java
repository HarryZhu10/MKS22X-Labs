import java.util.*;
public class Quick {

  public static int partition ( int [] data, int start, int end){
    Random rand = new Random();
    int pivotIndex = rand.nextInt(end - start + 1) + start;
    int p = data[pivotIndex];
  //  System.out.println("" + p);
    int[] ary = new int[end - start + 1];
    int originalPivotIndex = pivotIndex;
    pivotIndex = 0;
    ary[pivotIndex] = p;
    int count = 1;
    boolean on = true;

    for (int i = start; i <= end; i ++) {
      if (i != originalPivotIndex) {
        if (p > data[i]) {
          ary[pivotIndex + 1] = data[i];
          swap(ary, pivotIndex, pivotIndex + 1);
          pivotIndex ++;
        } else if (p < data[i]) {
          ary[ary.length - count] = data[i];
          count ++;
        } else {

          while (i <= end && p == data[i]) {
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
    }
//    System.out.println(Arrays.toString(data));

    putBack(data, ary, start, end);
  //  System.out.println(Arrays.toString(ary));
  //  System.out.println(Arrays.toString(data));
    return pivotIndex + start;
}


public static void putBack (int[] original, int[] newAry, int start, int end) {
  for (int i = start; i <= end; i ++) {
    original[i] = newAry[i - start];
  }
}

public static void swap (int[] data, int index1, int index2) {
  int x = data[index1];
  data[index1] = data[index2];
  data[index2] = x;
}


public static int quickselect(int[]data, int k) {
  int start = 0;
  int end = data.length - 1;
  int newIndex = -1;
  while (k != newIndex) {
      newIndex = partition(data, start, end);
      if (newIndex > k) {
        end = newIndex - 1;
      }
      if (newIndex < k) {
        start = newIndex + 1;
      }

  }
  return data[newIndex];
}


public static void main(String[] args) {
  int[] test1 = {999,999,999,4,3,2,1,0,999,999,999};
  int[] test2 = {1,2,2,3,45,6,43,2,23};
//System.out.println( "" + partition(test1, 3, 7));
System.out.println("" + quickselect(test2, 5));
//System.out.println(Arrays.toString(test2));
//System.out.println(Arrays.toString(test1));
}

}
