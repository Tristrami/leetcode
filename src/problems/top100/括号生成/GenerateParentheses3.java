package problems.top100.括号生成;

import java.util.*;

// 22. 括号生成
// https://leetcode.cn/problems/generate-parentheses/
public class GenerateParentheses3
{
    public static void main(String[] args)
    {
        System.out.println(generateParenthesis(10));
    }

    // 树形深搜
    public static List<String> generateParenthesis(int n)
    {
        List<String> combinations = new ArrayList<>(n * 2);
        dfs("", combinations, n, n);
        return combinations;
    }

    public static void dfs(String combination, List<String> combinations, int numLeft, int numRight)
    {
        // _ _ _ _
        // ( ( ) )
        // dfs 树第二层存放第一个位置括号放置的所有可能情况，树第三层存放第二个位置括号放置
        // 的所有可能情况 ... 树的叶子节点存放所有可能的括号组合
        if (numLeft == 0 && numRight == 0) {
            // 括号用完了，把当前组合放到 combinations 中
            combinations.add(combination);
            return;
        }
        if (numRight < numLeft) {
            // 如果右括号数量比左括号少，那一定是不合法的组合
            return;
        }
        // 先从左括号开始搜索
        if (numLeft > 0) {
            dfs(combination + '(', combinations, numLeft - 1, numRight);
        }
        // 再从右括号开始搜索
        if (numRight > 0) {
            dfs(combination + ')', combinations, numLeft, numRight - 1);
        }
    }
}
