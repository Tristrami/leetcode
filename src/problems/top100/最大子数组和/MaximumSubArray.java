package problems.top100.最大子数组和;

// 53. 最大子数组和
// https://leetcode.cn/problems/maximum-subarray/
public class MaximumSubArray
{
    public static void main(String[] args)
    {
        System.out.println(maxSubArray(new int[]{ -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    // O(n)
    public static int maxSubArray(int[] nums)
    {
        // 一旦 currentSum < 0，那么说明当前连续的子数组的和对后面的子数组的和起不到增大的效果，
        // 也就是说，当前子数组的和只会减小后面子数组的和，去掉当前连续子数组后，后面的连续子数组的
        // 和只会更大，所以直接将当前的连续子数组舍弃
        if (nums == null || nums.length == 0) return 0;
        int maxSum = nums[0], currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum < 0) {
                currentSum = 0;
                if (nums[i] > maxSum) {
                    // 如果数组中全是负数，就需要做这个判断
                    maxSum = nums[i];
                }
            } else if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}
