package problems.common.三数之和;

import java.util.*;

// 15. 三数之和
// https://leetcode.cn/problems/3sum/
public class ThreeSum
{
    public static void main(String[] args)
    {
        System.out.println(threeSum(new int[]{ -2, 0, 0, 2, 2 }));
    }

    public static List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> tuples = new ArrayList<>();
        if (nums == null) return tuples;
        Arrays.sort(nums);
        // 固定一个数字 k，定义双指针 left = index(k) + 1, right = nums.length - 1
        // k 的左边都是已经处理过了的数字，无需再重复处理
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果当前的数字已经用作过 k，就无需再处理，直接跳过，防止出现重复元组
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int target = -nums[i];
                int sum = nums[left] + nums[right];
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    List<Integer> tuple = new ArrayList<>();
                    tuple.add(nums[left]);
                    tuple.add(nums[right]);
                    tuple.add(nums[i]);
                    tuples.add(tuple);
                    int numLeft = nums[left], numRight = nums[right];
                    // 跳过相同的数字，防止出现重复元组
                    while (left < right && nums[left] == numLeft) left++;
                    while (left < right && nums[right] == numRight) right--;
                }
            }
        }
        return tuples;
    }
}
