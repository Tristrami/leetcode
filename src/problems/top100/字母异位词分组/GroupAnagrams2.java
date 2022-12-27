package problems.top100.字母异位词分组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 49. 字母异位词分组
// https://leetcode.cn/problems/group-anagrams/
public class GroupAnagrams2
{
    public static void main(String[] args)
    {
        // "eat", "tea", "tan", "ate", "nat", "bat"
        System.out.println(groupAnagrams(new String[]{ "eat", "tea", "tan", "ate", "nat", "bat" }));
    }

    // 哈希表，O(n * m)，n 为单词个数，m 为单词长度
    public static List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> groups = new ArrayList<>();
        if (strs == null || strs.length == 0) return groups;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            // 根据当前单词每个字母的使用个数生成一个字符串，如果两个单词生成的字符串的哈希值相同，则代表这两个单词是字母异位单词
            String key = getKey(strs[i]);
            List<String> group = map.getOrDefault(key, new ArrayList<>());
            group.add(strs[i]);
            map.put(key, group);
        }
        groups.addAll(map.values());
        return groups;
    }

    public static String getKey(String s)
    {
        // 根据当前单词每个字母的使用个数生成一个字符串，例如 "hi"，生成的字符串为 "h1i1"
        int[] cnt = new int[26];
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            cnt[Character.toLowerCase(s.charAt(i)) - 'a']++;
        }
        for (int i = 0; i < cnt.length; i++) {
            key.append('a' + i).append(cnt[i]);
        }
        return key.toString();
    }
}
