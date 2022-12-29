package problems.top100.不同路径;

public class UniquePaths2
{
    public static void main(String[] args)
    {
        System.out.println(uniquePaths(30, 20));
    }

    // 动态规划
    public static int uniquePaths(int m, int n)
    {
        // m: 行数, n: 列数
        int[][] dp = new int[m + 1][n + 1];
        // 从左上角到边界的路径都只有一条，要么都往右走，要么都往下走
        for (int i = 0; i <= m; i++) dp[i][1] = 1;
        for (int i = 0; i <= n; i++) dp[1][i] = 1;
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                // dp[i][j] 表示到达 (i, j) 位置的路径数
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}
