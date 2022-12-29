package problems.top100.编辑距离;

// 72. 编辑距离
// https://leetcode.cn/problems/edit-distance/
public class EditDistance
{
    public static void main(String[] args)
    {
        // horse
        //   ros
        // 替换
        // 插入
        // 删除
        // "horse", "ros"
        //
        System.out.println(minDistance("intention", "execution"));
    }

    public static int minDistance(String word1, String word2)
    {
        // dp[i][j] 表示 sub(word1, 0, i) 和 sub(word2, 0, j) 的最短编辑距离
        // dp[i][j] =
        // dp[i - 1][j - 1]  if word1[i] = word2[j]
        // min (
        //   dp[i - 1][j - 1] + 1 | 将 word1[i] 替换为 word2[j]
        //   dp[i][j - 1] + 1 | 在 word1 末尾插入 word2[j]
        //   dp[i - 1][j] + 1 | 删除 word1[i]
        // )  if word1[i] != word2[j]
        if (word1 == null || word2 == null) return 0;
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 初始化
        // 当 word2 为空串，word1 到 word2 的编辑距离为删除 word1 所有字母的操作数
        // 当 word1 为空串，word1 到 word2 的编辑距离为向 word1 插入 word2 所有字母的操作数
        // 当 word1 和 word2 均为空串时，编辑距离为 0
        for (int i = 0; i <= len1; i++) dp[i][0] = i;
        for (int i = 0; i <= len2; i++) dp[0][i] = i;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int swap = dp[i - 1][j - 1] + 1;
                    int insert = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    dp[i][j] = Math.min(Math.min(swap, insert), delete);
                }
            }
        }
        return dp[len1][len2];
    }
}
