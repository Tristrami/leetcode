package problems.top100.有效的括号;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses
{
    public static void main(String[] args)
    {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s)
    {
        if (s.length() < 2) return false;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put('(', ')'); put('{', '}'); put('[', ']');
        }};
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // 如果是左括号
                stack.push(c);
            } else if (!stack.empty() && map.get(stack.peek()) == c) {
                // 如果是右括号并且栈不为空且和栈顶的括号匹配
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}
