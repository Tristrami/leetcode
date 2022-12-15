package problems.top100.最长有效括号;

// 32. 最长有效括号
// https://leetcode.cn/problems/longest-valid-parentheses/
// 题解: https://leetcode.cn/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
public class LongestValidParentheses
{
    public static void main(String[] args)
    {
        // ()(())
        // (()())
        System.out.println(longestValidParentheses("(()())"));
    }

    public static int longestValidParentheses(String s)
    {
        // dp[i] 表示以 i 结尾的子串连续后缀（从后往前）有效括号的长度
        // dp[i] =
        // dp[i - 1]                            if s[i] == '(' && stack is empty | push s[i] into stack
        // 1                                    if s[i] == '(' && stack is not empty | push s[i] into stack
        // 1                                    if s[i] == ')' && stack is empty
        // dp[index('(') - 1] + dp[i - 1] + 2   if s[i] == ')' && stack is not empty ( means it matches the previous '(' ) | pop the top '('
        // 对最后一种情况的解释: 如果当前右括号与栈顶左括号匹配，那么 dp[i] = 左括号前面的连续有效括号长度 + 右括号前面的连续有效括号长度 + 2
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        // 放括号的下标，并不放括号本身
        int[] stack = new int[s.length()];
        int maxLen = 0, top = -1;
        dp[0] = 0;
        if (s.charAt(0) == '(') {
            stack[++top] = 0;
        }
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                dp[i] = 0;
                stack[++top] = i;
            } else {
                if (top >= 0) {
                    int index = stack[top--];
                    dp[i] = index > 0 ? dp[index - 1] + dp[i - 1] + 2 : dp[i - 1] + 2;
                } else {
                    dp[i] = 0;
                }
            }
            if (dp[i] > maxLen) maxLen = dp[i];
        }
        return maxLen;
    }
}
