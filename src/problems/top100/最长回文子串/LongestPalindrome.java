package problems.top100.最长回文子串;

// 5. problems.top100.最长回文子串
// https://leetcode.cn/problems/longest-palindromic-substring/
public class LongestPalindrome
{
    public static void main(String[] args)
    {
        // 共有四种情况
        // 1. abbba
        // 2. aaab
        // 3. abbb
        // 4. aaaa
        System.out.println(longestPalindrome("c"));
    }

    // 中心扩散法
    public static String longestPalindrome(String s)
    {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int start = 0, end = 0, maxLen = 0;
        for (int i = 0; i < len; i++) {
            int left = i, right = i, curLen = 1;
            // 寻找中心字符串，如 abbba 中心字符串就是 bbb
            while (right < len - 1 && s.charAt(i) == s.charAt(right)) {
                right++;
            }
            // 让 right 指向中心字符串最后一个字符，例如上面的例子，right 指向 bbb 的最后一个 b
            // 那么此时 left 指向 中心字符串的开头，而 right 指向中心字符串末尾
            right--;
            // 向中心的两边扩散，判断是否回文
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                curLen = right - left + 1;
                if (curLen > maxLen) {
                    maxLen = curLen;
                    start = left;
                    end = right;
                }
                left--;
                right++;
            }
        }
        return s.substring(start, end + 1);
    }
}