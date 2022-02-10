public class RecursionClasswork {

public static boolean groupSum(int start, int[] nums, int target) {
  if (nums.length == 0) {
    return target == 0;
  }

  if (start != nums.length) {
    return (groupSum(start + 1, nums, target) || groupSum(start + 1, nums, target - nums[start]));
  } else {
    return target == 0;
  }
}


public static boolean splitArray(int[] nums) {
  if (nums.length == 0) {
    return target == 0;
  }

  if (start != nums.length) {
    return (groupSum(start + 1, nums, target) || groupSum(start + 1, nums, target - nums[start]));
  } else {
    return target == 0;
  }
}




}
