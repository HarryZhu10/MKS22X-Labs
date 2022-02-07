public main PartialSum {


  public static void main(String[] args) {

  }



// you need another method that tracks the index


public static boolean partialSum (int[] nums, int n) {
  if (nums.length > 0) {
    if (nums[nums.length - 1] != n) {
      return partialSum(nums, n);
    }
  } else {

  }

}

}
