public class Driver {
public static void main(String[] args) {
  int[] nums = {1,2,3,3,6};
  int[] empty = {};
System.out.println(RecursionClasswork.groupSum(0, nums, 6));
System.out.println(RecursionClasswork.groupSum(0, nums, 16));
System.out.println(RecursionClasswork.groupSum(0, nums, 15));
System.out.println(RecursionClasswork.groupSum(0, nums, 0));
System.out.println(RecursionClasswork.groupSum(0, nums, 3));
System.out.println(RecursionClasswork.groupSum(0, empty, 15));
System.out.println(RecursionClasswork.groupSum(0, empty, 0));
}
}
