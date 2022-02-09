public class RecursionClasswork {

public static void main(String[] args) {

}

public static boolean groupSum(int start, int[] nums, int target) {
  if (targetValue != 0) {
    if (!groupSum(start + 1, nums, targetValue)) {
      if (targetValue - nums[start] > 0) {
      return groupSum(start + 1, nums, targetValue - nums[start]);
      }
    } else {
      return groupSum(start + 1, nums, targetValue);
    }
  } else {
    return true;
  }
}



}
