package problems.all.整数反转;

// 7. problems.all.整数反转
// https://leetcode.cn/problems/reverse-integer/
public class ReverseInteger
{
    public static void main(String[] args)
    {
        System.out.println(reverse(-123));
    }

    public static int reverse(int x)
    {
        int ans = 0;
        while (x != 0) {
            int digit = x % 10;
            // 判断是否超过 int 范围，ans * 10 + digit <= Integer.MAX_VALUE 或者 ans * 10 + digit >= Integer.MIN_VALUE
            // 当 ans < Integer.MAX_VALUE / 10 或 ans > Integer.MIN_VALUE 时，由于 digit 的取值范围为 [0-9]，所以上述不等
            // 式依然成立；但是当 ans = Integer.MAX_VALUE / 10 时（Integer.MAX_VALUE = 2147483647，Integer.MAX_VALUE / 10
            // = 214748364），所以 digit 的取值范围必须是 [0-7]，同理，当 ans = Integer.MIN_VALUE 时（Integer.MIN_VALUE =
            // -2147483648，Integer.MIN_VALUE / 10 = -214748364），digit 的取值范围必须是 [0-(-8)]
            if ((ans < Integer.MIN_VALUE / 10 || ans == Integer.MIN_VALUE / 10 && digit < -8)
                    || (ans > Integer.MAX_VALUE / 10 || ans == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            ans = ans * 10 + digit;
            x /= 10;
        }
        return ans;
    }
}
