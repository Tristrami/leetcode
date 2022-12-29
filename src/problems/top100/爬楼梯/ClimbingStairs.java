package problems.top100.爬楼梯;

// 70. 爬楼梯
// https://leetcode.cn/problems/climbing-stairs/
public class ClimbingStairs
{
    public static void main(String[] args)
    {
        System.out.println(climbStairs(1));
    }

    public static int climbStairs(int n)
    {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n > 1) dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
