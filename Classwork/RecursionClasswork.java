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





public boolean splitArray(int start, int[] nums, int target) {
  if (nums.length == 0) {
    return target == 0;
  }

  if (start != nums.length) {
    return splitArray(start + 1, nums, target + nums[start]) || splitArray(start + 1, nums, target - nums[start]);
  } else {
    return target == 0;
  }
}


public static boolean groupSum6(int start, int[] nums, int target) {
  if (nums.length == 0) {
    return target == 0;
  }

  if (start != nums.length) {
    if (nums[start] == 6) {
      return groupSum6(start + 1, nums, target - nums[start]);
    } else {
    return (groupSum6(start + 1, nums, target) || groupSum6(start + 1, nums, target - nums[start]));
  }
  } else {
    return target == 0;
  }
}


public boolean splitOdd10(int start, int[] nums, int target1, int target2) {
  if (nums.length == 0) {
    return target1 && target2 == 0;
  }

  if (start != nums.length) {
    return splitArray(start + 1, nums, target) || splitArray(start + 1, nums, target - nums[start]);
  } else {

    return target1 % 2 == 1 && target2 % 10 == 0;
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
    int amount = 0;


    if (nums[start] == 5 && nums[start + 1] == 1) {
      amount -= 5;
    }

    if (nums[start] == 5) {
      amount += 5;
      return (groupSum5(start + 1, nums, target - amount) || groupSum5(start + 1, nums, target));
    }

      return (groupSum5(start + 1, nums, target - nums[start]) || groupSum5(start + 1, nums, target));


  } else {
    return target == 0;
  }
}




}
