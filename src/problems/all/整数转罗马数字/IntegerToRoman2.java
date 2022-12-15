package problems.all.整数转罗马数字;

// 12. 整数转罗马数字
// https://leetcode.cn/problems/integer-to-roman/
public class IntegerToRoman2
{
    public static void main(String[] args)
    {
        System.out.println(intToRoman(1994));
    }

    private static final String[] thousands = {"", "M", "MM", "MMM"};
    private static final String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    // 贪心法
    public static String intToRoman(int num)
    {
        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }
}
