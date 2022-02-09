public class RecursionClasswork {

public static void main(String[] args) {

}

public static boolean groupSum(int start, int[] nums, int target) {
  if (nums.length == 0) {
    return target == 0;
  }

  if (target != 0) {
    if (start == nums.length - 1) {
      return false;
    }
    return (groupSum(start + 1, nums, target) || groupSum(start + 1, nums, target - nums[start]));
  } else {
    return true;
  }
}



}
