package problems.top100.不同路径;

public class UniquePaths
{
    public static void main(String[] args)
    {
        System.out.println(uniquePaths(30, 70));
    }

    // 暴力搜, 超时
    public static int uniquePaths(int m, int n)
    {
        // m: 行数, n: 列数
        return dfs(m, n, 1, 1);
    }

    public static int dfs(int m, int n, int x, int y)
    {
        if (x == n || y == m) {
            // 只要走到边界，剩下的路径就确定了
            return 1;
        } else if (x > n || y > m) {
            return 0;
        }
        return dfs(m, n, x + 1, y) + dfs(m, n, x, y + 1);
    }
    // 2^12
}
