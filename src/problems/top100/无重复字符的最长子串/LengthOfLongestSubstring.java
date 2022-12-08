package problems.top100.无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

// 3. problems.top100.无重复字符的最长子串
// https://leetcode.cn/problems/longest-substring-without-repeating-characters/
public class LengthOfLongestSubstring
{
    public static void main(String[] args)
    {
        // abcabcbb
        // pwwkew
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }

    public static int lengthOfLongestSubstring(String s)
    {
        int size = s.length();
        if (size < 2) {
            return size;
        }
        Map<Character, Integer> charToIndex = new HashMap<>(size);
        int maxLen = 1;
        int left = 0, right = 1;
        // 先把第一个字符放进去
        charToIndex.put(s.charAt(0), 0);
        while (right < size) {
            char c = s.charAt(right);
            // 检查当前字符在以 left 开头 right 结尾的字串中是否重复
            // 第二个条件的目的是检查重复的字符是否在字串的范围内
            if (charToIndex.containsKey(c) && charToIndex.get(c) >= left) {
                // 如果重复，让 left 指向字串中重复字符的下一个字符
                left = charToIndex.get(c) + 1;
                charToIndex.put(c, right);
            } else {
                // 如果不重复，把当前字符与下标的对应关系记录下来，并且更新 maxLen
                int len = right - left + 1;
                maxLen = Math.max(len, maxLen);
                charToIndex.put(c, right);
            }
            right++;
        }
        return maxLen;
    }
}
