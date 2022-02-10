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

public static boolean groupNoAdj(int start, int[] nums, int target) {
  if (nums.length == 0) {
    return target == 0;
  }

  if (start < nums.length) {
    return (groupNoAdj(start + 1, nums, target) || groupNoAdj(start + 2, nums, target - nums[start]));
  } else {
    return target == 0;
  }
}


public static boolean groupSum5(int start, int[] nums, int target) {
  if (nums.length == 0) {
    return target == 0;
  }

  if (start < nums.length) {

    if (nums[start] == 5) {
      if (!(start == nums.length - 1) && nums[start + 1] == 1) {
        return (groupSum5(start + 1, nums, target - nums[start]) || groupSum(start + 1, nums, target));
      } else {
        return groupSum5(start + 1, nums, target - 5);
      }
    } else {
      return (groupSum5(start + 1, nums, target - nums[start]) || groupSum(start + 1, nums, target));
    }


  } else {
    return target == 0;
  }
}




}
