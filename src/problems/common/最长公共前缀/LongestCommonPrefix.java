package problems.common.最长公共前缀;

// 14. 最长公共前缀
// https://leetcode.cn/problems/longest-common-prefix/
public class LongestCommonPrefix
{
    public static void main(String[] args)
    {
        System.out.println(longestCommonPrefix(new String[]{ "ab", "a" }));
    }

    public static String longestCommonPrefix(String[] strs)
    {
        // 假设以下标 i 结尾的前缀是 strs 中所有字符串的公共前缀，在其中取一个长度最短的字符串 str[m]，则对于 strs
        // 中所有其他字符串 str[n] 来说，需要满足 str[n].substring(0, i + 1) = str[m].substring(0, i + 1)，
        // 其中 m 是定值，n 的范围是 (0 <= n < str.length && n != m) ，如果有任意一个 s 不满足该条件，那么以下标
        // i 结尾的前缀就不是 strs 中所有字符串的公共前缀。根据这个条件，我们可以先找到最短字符串的下标，并且让 i 从
        // 0 开始不断递增，直到以 i 结尾的前缀不是公共前缀，那么就找到了最长公共前缀了。这里要注意，找最短字符串的原因
        // 是最长公共前缀受限于最短的那个字符串，最长公共前缀长度只可能 <= 最短字符串长度

        if (strs == null || strs.length == 0) {
            return "";
        } else if (strs.length < 2) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        int shortestStringIndex = 0, minLen = strs[0].length();
        // 找最短字符串
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
                shortestStringIndex = i;
            }
        }
        // 找最长公共前缀
        for (int i = 0; i < strs[shortestStringIndex].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}
