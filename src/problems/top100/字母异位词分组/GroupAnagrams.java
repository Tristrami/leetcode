package problems.top100.字母异位词分组;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 49. 字母异位词分组
// https://leetcode.cn/problems/group-anagrams/
public class GroupAnagrams
{
    public static void main(String[] args)
    {
        // "eat", "tea", "tan", "ate", "nat", "bat"
        System.out.println(groupAnagrams(new String[]{ "eat", "tea", "tan", "ate", "nat", "bat" }));
    }

    public static List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> groups = new ArrayList<>();
        if (strs == null || strs.length == 0) return groups;
        boolean[] v = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (!v[i]) {
                List<String> group = new ArrayList<>();
                group.add(strs[i]);
                v[i] = true;
                for (int j = i + 1; j < strs.length; j++) {
                    if (!v[j] && isAnagram(strs[i], strs[j])) {
                        group.add(strs[j]);
                        v[j] = true;
                    }
                }
                groups.add(group);
            }
        }
        return groups;
    }

    public static boolean isAnagram(String s1, String s2)
    {
        // 判断两个单词是否相互为字母异位单词，分别统计两个单词用到的每一个字母的数量，再逐一比较统计结果，
        // 如果某一字母使用数量两者不一致，那么说明他们相互不是字母异位单词，如果两者所有字母使用数量均一致，
        // 那么他们相互是字母异位单词
        if (s1.length() != s2.length()) return false;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            cnt1[Character.toLowerCase(c1) - 'a']++;
            cnt2[Character.toLowerCase(c2) - 'a']++;
        }
        for (int i = 0, j = 0; i < cnt1.length; i++, j++) {
            if (cnt1[i] != cnt2[j]) {
                return false;
            }
        }
        return true;
    }
}
