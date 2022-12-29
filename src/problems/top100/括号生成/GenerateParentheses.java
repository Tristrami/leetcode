package problems.top100.括号生成;

import java.util.ArrayList;
import java.util.List;

// 22. 括号生成
// https://leetcode.cn/problems/generate-parentheses/
public class GenerateParentheses
{
    public static void main(String[] args)
    {
        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n)
    {
        // ( ( ) )
        StringBuilder sb = new StringBuilder();
        // 括号的组合，递归层数 n 代表 combination 的第 n 个位置
        StringBuilder combination = new StringBuilder();
        List<String> combinations = new ArrayList<>();
        // 标志当前字符是否在 combination 中
        boolean[] v = new boolean[n * 2];
        for (int i = 0; i < n; i++) sb.append('(');
        for (int i = 0; i < n; i++) sb.append(')');
        String s = sb.toString();
        // 生成所有括号组合
        search(s, combinations, combination, v, n);
        // TODO 筛选出合法的括号组合

        return combinations;
    }

    public static void search(String s, List<String> combinations, StringBuilder combination, boolean[] v, int n)
    {
        // 遍历不在 combination 中的字符（判断依据是当前字符下标与 combination 中字符下标不重复），分别将它们放在当前位置上
        for (int i = 0; i < s.length(); i++) {
            if (!v[i]) {
                combination.append(s.charAt(i));
                v[i] = true;
                search(s, combinations, combination, v, n);
                // 回溯，当括号数 = 括号对数 * 2 时将当前的括号组合加入 combinations 中
                if (combination.length() == n * 2) {
                    combinations.add(combination.toString());
                }
                // 删除当前位置字符
                combination.deleteCharAt(combination.length() - 1);
                v[i] = false;
            }
        }
    }
}
