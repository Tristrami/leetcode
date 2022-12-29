package problems.top100.最大子数组和;

// 53. 最大子数组和
// https://leetcode.cn/problems/maximum-subarray/
public class MaximumSubArray2
{
    public static void main(String[] args)
    {
        System.out.println(maxSubArray(new int[]{ -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    // 动态规划，O(n)
    public static int maxSubArray(int[] nums)
    {
        // dp[i] 表示经过 nums[i] 的连续子数组的最大和
        // dp[i] =
        // dp[i - 1] + nums[i]  if dp[i - 1] > 0
        // nums[i]              if dp[i - 1] <= 0

        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int maxSum = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            if (dp[i] > maxSum) {
                maxSum = dp[i];
            }
        }
        return maxSum;
    }
}
