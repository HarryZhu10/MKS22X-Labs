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





public static boolean splitArray(int start, int[] nums, int target) {
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


public static boolean splitOdd10(int start, int[] nums, int target1, int target2) {
  if (nums.length == 0) {
    return target1 % 2 == 1 && target2 % 10 == 0;
  }

  if (start != nums.length) {
    return splitOdd10(start + 1, nums, target1 + nums[start], target2) || splitOdd10(start + 1, nums, target1, target2 + nums[start]);
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

  if (start != nums.length) {
    if (nums[start] % 5 == 0) {
      if (start < nums.length - 1 && nums[start + 1] == 1) {
      return groupSum5(start + 2, nums, target - nums[start]);
    } else {
      return groupSum5(start + 1, nums, target - nums[start]);
      }
    }
    return (groupSum5(start + 1, nums, target) || groupSum5(start + 1, nums, target - nums[start]));
  } else {
    return target == 0;
  }
}



/*

if (nums[start] % 5 == 0) {
  if (start == nums.length - 1) {
    return groupSum5(start + 1, nums, target - 5);
  } else {
    if (nums[start + 1] % 10 == 1) {
      return groupSum5(start + 2, nums, target - 5);
    }
  }
}
*/





public static boolean split53 (int start, int[] nums, int target) {
  if (nums.length == 0) {
    return target == 0;
  }

  if (start != nums.length) {
    if (nums[start] % 5 == 0) {
      return split53(start + 1, nums, target + nums[start]);
    } else if (nums[start] % 3 == 0) {
      return split53(start + 1, nums, target - nums[start]);
    }
    return split53(start + 1, nums, target + nums[start]) || split53(start + 1, nums, target - nums[start]);
  } else {
    return target == 0;
  }
}


public static boolean groupSumClump(int start, int[] nums, int target) {
  if (nums.length == 0) {
    return target == 0;
  }

  if (start != nums.length) {
            int amount = 1;
            int sum = 0;
    if (start != nums.length - 1) {
        while (nums[start] == nums[start + amount]) {
          amount ++;
        }
         sum = amount * nums[start];
    }
    if (amount > 1) {
      return (groupSumClump(start + amount, nums, target - sum) || groupSumClump(start + amount, nums, target));
    }
    return (groupSumClump(start + 1, nums, target) || groupSumClump(start + 1, nums, target - nums[start]));
  } else {
    return target == 0;
  }
}


}
