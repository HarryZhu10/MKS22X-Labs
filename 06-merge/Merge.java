import java.util.*;

public class Merge {


public static void mergesort (int[] data) {

}


public static int[] merge(int[] left, int[] right) {
  int[] merged = new int[left.length + right.length];
  int rIndex = 0;
  int lIndex = 0;
  int count = 0;
  for (int i = 0; count < merged.length && rIndex < right.length && lIndex < left.length; count ++) {
    if (left[lIndex] < right[rIndex]) {
      merged[count] = left[lIndex];
      lIndex ++;
      System.out.println(Arrays.toString(merged));
    } else if (left[lIndex] > right[rIndex]) {
      merged[count] = right[rIndex];
      rIndex ++;
            System.out.println(Arrays.toString(merged));
    } else {
      merged[count] = right[rIndex];
      merged[count + 1] = left[lIndex];
      rIndex ++;
      lIndex ++;
      count ++;
            System.out.println(Arrays.toString(merged));
    }
  }

if (rIndex == right.length) {
  for (int i = lIndex; i < left.length; i ++) {
    merged[count] = left[lIndex];
    lIndex ++;
    count ++;
          System.out.println(Arrays.toString(merged));
  }
  } else if (lIndex == left.length) {
    for (int i = rIndex; i < right.length; i ++) {
    merged[count] = right[rIndex];
    rIndex ++;
    count ++;
          System.out.println(Arrays.toString(merged));
  }
}
  return merged;
}


public static void merge(int[] destination, int [] left, int[] right) {
  int rIndex = 0;
  int lIndex = 0;
  int count = 0;
  for (int i = 0; count < destination.length && rIndex < right.length && lIndex < left.length; count ++) {
    if (left[lIndex] < right[rIndex]) {
      destination[count] = left[lIndex];
      lIndex ++;

    } else if (left[lIndex] > right[rIndex]) {
      destination[count] = right[rIndex];
      rIndex ++;

    } else {
      destination[count] = right[rIndex];
      destination[count + 1] = left[lIndex];
      rIndex ++;
      lIndex ++;
      count ++;

    }
  }

if (rIndex == right.length) {
  for (int i = lIndex; i < left.length; i ++) {
    destination[count] = left[lIndex];
    lIndex ++;
    count ++;

  }
  } else if (lIndex == left.length) {
    for (int i = rIndex; i < right.length; i ++) {
    destination[count] = right[rIndex];
    rIndex ++;
    count ++;

  }
}

}


public static void main(String[] args) {
  int[] test1 = {2,3,3,3,4,7};
  int[] test2 = {3,5,5,6,8};
  int[] test3 = new int[11];
//System.out.println(Arrays.toString(merge(test2, test1)));
merge(test3, test1, test2);
System.out.println(Arrays.toString(test3));

}


}
