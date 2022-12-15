package problems.all.整数转罗马数字;

// 12. 整数转罗马数字
// https://leetcode.cn/problems/integer-to-roman/
public class IntegerToRoman
{
    public static void main(String[] args)
    {
        System.out.println(intToRoman(1994));
    }

    // 模拟法
    public static String intToRoman(int num)
    {
        int[] values = new int[]{ 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = new String[]{ "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            // 如果当前数字比当前罗马字符大，就用数字除以罗马字符来计算需要几个当前字符，例如 3 / 1 = 3，就需要三个 I
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}
