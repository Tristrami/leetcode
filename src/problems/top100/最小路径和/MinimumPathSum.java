package problems.top100.最小路径和;

// 64. 最小路径和
// https://leetcode.cn/problems/minimum-path-sum/
public class MinimumPathSum
{
    public static void main(String[] args)
    {
        // [1,3,1],
        // [1,5,1],
        // [4,2,1]
        System.out.println(minPathSum(new int[][]{ { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
    }

    public static int minPathSum(int[][] grid)
    {
        // dp[i][j] 表示到达 (i, j) 位置的最小路径和，每次选择花费最小的走法即可
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // 初始化边界的路径和
        for (int i = 1; i < m; i++) dp[i][0] = grid[i][0] + dp[i - 1][0];
        for (int i = 1; i < n; i++) dp[0][i] = grid[0][i] + dp[0][i - 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
