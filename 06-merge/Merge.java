public class Merge {


public static void mergesort (int[] data) {

}


public static int[] merge(int[] left, int[] right) {
  int[] merged = new int[left.length + right.length];
  int rIndex = 0;
  int lIndex = 0;

  for (int i = 0; i < merged.length; i ++) {
    if (left[lIndex] < right[rIndex]) {
      merged[i] = left[lIndex];
      lIndex ++;
    } else if (left[lIndex] > right[rIndex]) {
      merged[i] = right[rIndex];
      rIndex ++;
    } else {
      merged[i] = right[rIndex];
      merged[i + 1] = left[lIndex];
      rIndex ++;
      lIndex ++;
      i ++;
    }
  }
  return merged;
}


public static void merge(int[] destination, int [] left, int[] right) {

}

}
