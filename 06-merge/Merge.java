import java.util.*;

public class Merge{
        /*merge takes two sorted arrays and returns a new array that combines all
         *elements of both arrays in asorted order.
         *@left a sorted array (this is a precondition)
         *@right a sorted array (this is a precondition)
         *@return a sorted array that contains all elements of left and right
         */
         public static int[] merge(int[] left, int[] right) {
           int[] merged = new int[left.length + right.length];
           int rIndex = 0;
           int lIndex = 0;
           int count = 0;
           for (int i = 0; count < merged.length && rIndex < right.length && lIndex < left.length; count ++) {
             if (left[lIndex] < right[rIndex]) {
               merged[count] = left[lIndex];
               lIndex ++;
              // System.out.println(Arrays.toString(merged));
             } else if (left[lIndex] > right[rIndex]) {
               merged[count] = right[rIndex];
               rIndex ++;
                  //   System.out.println(Arrays.toString(merged));
             } else {
               merged[count] = right[rIndex];
               merged[count + 1] = left[lIndex];
               rIndex ++;
               lIndex ++;
               count ++;
                    // System.out.println(Arrays.toString(merged));
             }
           }

         if (rIndex == right.length) {
           for (int i = lIndex; i < left.length; i ++) {
             merged[count] = left[lIndex];
             lIndex ++;
             count ++;
                //   System.out.println(Arrays.toString(merged));
           }
           } else if (lIndex == left.length) {
             for (int i = rIndex; i < right.length; i ++) {
             merged[count] = right[rIndex];
             rIndex ++;
             count ++;
                //   System.out.println(Arrays.toString(merged));
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

        /*mergesortH is the actual mergesort method.
        *@data the array to be sorted
        *@return a new array that is the sorted version of data.
        */
        public static int[] mergesortH(int [] data){
          //********************
          //COMPLETE THIS METHOD
          //********************
          //if more than 1 element{
            //left = copy half of data
            //right = copy other half of data
            //sort each half and merge them together
          //}
          if (data.length > 1) {
            int[] left = new int[data.length / 2];
            int[] right = new int[data.length - data.length / 2];
            for (int i = 0; i < data.length; i ++) {
              if (i < left.length) {
                left[i] = data[i];
              } else {
                right[i - left.length] = data[i];
              }
            }

            return merge(mergesortH(left), mergesortH(right));
          } else {
              return data;
          }
        }

        /*mergesort uses the recursive mergesortH method to create a sorted
        *version of the array. It then copies the data back into the original
        *array. (This is for compatibility with prior sort testers)
        *@param data the array to be sorted, this will be modified by the method
        */
        public static void mergesort(int [] data){
          int [] temp  =  mergesortH(data);
          for(int i = 0; i < data.length; i++){
            data[i] = temp[i];
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
