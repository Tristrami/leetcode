package problems.all.不同路径2;

// 63. 不同路径 II
// https://leetcode.cn/problems/unique-paths-ii/
public class UniquePathsII
{
    public static void main(String[] args)
    {
        // { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }

        System.out.println(uniquePathsWithObstacles(new int[][]{ { 0, 1 }, { 0, 0 } }));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        boolean hasObstacle = false;
        for (int i = 0; i < m; i++)
        {
            if (obstacleGrid[i][0] == 1) hasObstacle = true;
            dp[i][0] = hasObstacle ? 0 : 1;
        }
        hasObstacle = false;
        for (int i = 0; i < n; i++)
        {
            if (obstacleGrid[0][i] == 1) hasObstacle = true;
            dp[0][i] = hasObstacle ? 0 : 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    // 如果当前位置为障碍物，直接标记为不可达
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
