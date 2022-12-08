package problems.top100.最长回文子串;

// 5. problems.top100.最长回文子串
// https://leetcode.cn/problems/longest-palindromic-substring/
public class LongestPalindrome2
{
    public static void main(String[] args)
    {
        System.out.println(longestPalindrome("abbb"));
    }

    // 中心扩散法，需要判断回文串字符数奇偶
    public static String longestPalindrome(String s)
    {
        int len = s.length();
        int start = 0, end = 0, maxLen = 0;
        for (int i = 0; i < len; i++) {
            // 奇数个字符的回文串长度
            int oddLen = expand(s, len, i, i);
            // 偶数个字符的回文串长度
            int evenLen = expand(s, len, i, i + 1);
            int curLen = Math.max(oddLen, evenLen);
            if (curLen > maxLen) {
                maxLen = curLen;
                if (oddLen > evenLen) {
                    start = i - (curLen - 1) / 2;
                    end = i + (curLen - 1) / 2;
                } else {
                    start = i - (curLen - 2) / 2;
                    end = i + (curLen - 2) / 2 + 1;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expand(String s, int len, int left, int right)
    {
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // (right - 1) - (left + 1) + 1
        return right - left - 1;
    }
}
