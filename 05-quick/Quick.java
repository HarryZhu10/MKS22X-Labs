import java.util.*;
public class Quick {

public static int partition(int[] data, int start, int end){
    int pivotIndex = (int) (Math.random() * (end - start + 1) + start);
    int index = start + 1;
    int adjacentEqual = 0;
swap(data, pivotIndex, start);

    for (int i = start + 1; i <= end; i++){
        if (data[i] == data[start]) {
            if (adjacentEqual % 2 == 0) {
                adjacentEqual ++;
                continue;
            }
            else {
                adjacentEqual ++;
            }
        }
        if (data[i] <= data[start]){

            swap(data, i, index);
            index ++;
        }
    }

swap(data, index - 1, start);
  //  System.out.println(Arrays.toString(data));
    return index - 1;
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

public static void quicksort(int[]data) {
quicksort(data, 0, data.length - 1);
}


public static void quicksort (int [] data, int start, int end) {
  if (data.length != 0) {


  if (start < end) {
    int p = partition(data, start, end);
    quicksort(data, start, p - 1);
//System.out.println(Arrays.toString(data));
    quicksort(data, p + 1, end);
  //  System.out.println(Arrays.toString(data));
  }
}
}


public static void main(String[] args) {
  int[] test1 = {999,999,999,4,3,2,1,0,999,999,999};
  int[] test2 = {1,2,2,3,45,6,43,2,23};
  int[] test3 = {3,5,3,6,7,8,53,3,23,4,3};
  int newIndex = partition(test3, 0, 10);
/*
System.out.println( "" + newIndex);
System.out.println("");
System.out.println("" + partition(test3, 0, newIndex - 1)); //values less than pivot
System.out.println("");
System.out.println("" + partition(test3,newIndex + 1, test3.length - 1));
*/
//System.out.println("" + quickselect(test2, 5));
//quicksort(test3);
//System.out.println(Arrays.toString(test3));
//System.out.println(Arrays.toString(test2));
//System.out.println(Arrays.toString(test1));
}

}
