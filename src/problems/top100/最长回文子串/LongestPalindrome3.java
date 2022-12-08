package problems.top100.最长回文子串;

// 5. problems.top100.最长回文子串
// https://leetcode.cn/problems/longest-palindromic-substring/
public class LongestPalindrome3
{
    public static void main(String[] args)
    {
        System.out.println(longestPalindrome("aaaa"));
    }

    // 动态规划
    public static String longestPalindrome(String s)
    {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        int begin = 0, end = 0, maxLen = 0;
        boolean[][] dp = new boolean[len][len];
        // 遍历时要从长度小的字符串开始遍历，在遍历到 dp[i][j] 时，必须保证 dp[i + x][j - y] (i + x <= j && j - y >= x)
        // 已经被遍历到，所以要在最外层循环递增右边界，也就是 j
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i + 1 <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        begin = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(begin, end + 1);
    }
}
