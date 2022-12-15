package problems.all.字符串转换正数;

// 8. 字符串转换整数 (atoi)
// https://leetcode.cn/problems/string-to-integer-atoi/
public class StringToInteger
{
    public static void main(String[] args)
    {
        System.out.println(myAtoi("2147483648"));
    }

    // 垃圾方法
    public static int myAtoi(String s)
    {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = readNumberFromString(s);
        if (!s.matches(".*\\d+.*")) {
            return 0;
        }
        int negativeFlag, ans = 0;
        if (!Character.isDigit(s.charAt(0))) {
            negativeFlag = s.charAt(0) == '-' ? -1 : 1;
            s = s.substring(1);
        } else {
            negativeFlag = 1;
        }
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            if (ans < Integer.MIN_VALUE / 10 || ans == Integer.MIN_VALUE / 10 && digit > 8) {
                return Integer.MIN_VALUE;
            } else if (ans > Integer.MAX_VALUE / 10 || ans == Integer.MAX_VALUE / 10 && digit > 7) {
                return Integer.MAX_VALUE;
            } else {
                ans = ans * 10 + negativeFlag * digit;
            }
        }
        return ans;
    }

    public static String readNumberFromString(String s)
    {
        StringBuilder sb = new StringBuilder();
        boolean hasOperator = false;
        s = s.trim();
        if (s.length() == 0) {
            return "";
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            sb.append(s.charAt(0));
            hasOperator = true;
        }
        for (int i = hasOperator ? 1 : 0; i < s.length() && Character.isDigit(s.charAt(i)); i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
