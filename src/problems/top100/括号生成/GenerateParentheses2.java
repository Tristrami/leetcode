package problems.top100.括号生成;

import java.util.*;
import java.util.stream.Collectors;

// 22. 括号生成
// https://leetcode.cn/problems/generate-parentheses/
public class GenerateParentheses2
{
    public static void main(String[] args)
    {
        System.out.println(generateParenthesis(5));
    }

    // 堆栈模拟递归，枚举出所有括号的组合，筛选出长度为 n * 2 并且合法的括号的组合，垃圾方法
    public static List<String> generateParenthesis(int n)
    {
        // ( ( ) )
        StringBuilder sb = new StringBuilder();
        // 括号的组合，递归层数 n 代表 combination 的第 n 个位置
        StringBuilder combination = new StringBuilder();
        // 标志当前字符是否在 combination 中
        boolean[] v = new boolean[n * 2];
        for (int i = 0; i < n; i++) sb.append('(');
        for (int i = 0; i < n; i++) sb.append(')');
        String s = sb.toString();
        // 生成所有括号组合
        List<String> combinations = generate(s, n);
        Set<String> set = new HashSet<String>(){{
            for (String s : combinations) {
                if (isValidParentheses(s)) {
                    this.add(s);
                }
            }
        }};
        return new ArrayList<>(set);
    }

    public static List<String> generate(String s, int n)
    {
        // ( ( ) )
        List<String> combinations = new ArrayList<>();
        Stack<StackNode> stack = new Stack<>();
        boolean[] v = new boolean[n * 2];
        stack.push(new StackNode(0, false, new StringBuilder()));
        while (!stack.empty()) {
            StackNode stackNode = stack.pop();
            StringBuilder combination = stackNode.combination;
            for (int i = stackNode.index; i < s.length(); i++) {
                if (!stackNode.methodInvoked) {
                    if (!v[i]) {
                        combination.append(s.charAt(i));
                        v[i] = true;
                        stackNode.methodInvoked = true;
                        stackNode.index = i;
                        stack.push(stackNode);
                        stack.push(new StackNode(0, false, combination));
                        break;
                    }
                } else {
                    if (combination.length() == n * 2) {
                        combinations.add(combination.toString());
                    }
                    combination.deleteCharAt(combination.length() - 1);
                    v[i] = false;
                    stackNode.methodInvoked = false;
                }
            }
        }
        return combinations;
    }

    public static boolean isValidParentheses(String s)
    {
        if (s.length() < 2) return false;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (!stack.empty()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}

class StackNode
{
    // 当前调用状态的 i 的值
    public int index;
    // 是否执行了递归调用
    public boolean methodInvoked;
    public StringBuilder combination;

    public StackNode() {}

    public StackNode(int index, boolean returned, StringBuilder combination)
    {
        this.index = index;
        this.methodInvoked = returned;
        this.combination = combination;
    }
}
