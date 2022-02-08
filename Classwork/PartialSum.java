public class PartialSum {



public static boolean partialSum(int start,int[] arr,int targetValue) {
  if (targetValue != 0) {
    if (!partialSum(start + 1, arr, targetValue)) {
      if (targetValue - arr[start] > 0) {
        return partialSum(start + 1, arr, targetValue - arr[start]);
      }
    }
    else {
      return partialSum(start + 1, arr, targetValue);
    }
  } else {
    return true;
  }
}

}
