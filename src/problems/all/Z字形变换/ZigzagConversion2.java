package problems.all.Z字形变换;

// 6. Z 字形变换
// https://leetcode.cn/problems/zigzag-conversion/
public class ZigzagConversion2
{
    public static void main(String[] args)
    {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    // 优化版本，不需要遍历 panel
    public static String convert(String s, int numRows)
    {
        if (s == null || s.length() < 2 || numRows < 2) {
            return s;
        }
        int len = s.length();
        // 由于只需要逐行输出 panel 中的字符，所以字符所在的列号其实用不上，只需要把在同一行的字符都放在一起就可以了，
        // 这里的 chars 就是这个功能，chars[i] 存储了 panel 中第 i 行的所有字符
        char[][] chars = new char[numRows][len];
        int[] size = new int[numRows];
        int pos = 0, x = 0;
        while (pos < len) {
            // 先往下走
            for (int y = 0; pos < len && y < numRows; y++, pos++) {
                // 将在同一行的字符放在一起
                chars[y][size[y]++] = s.charAt(pos);
            }
            // 再往右上走
            for (int y = numRows - 2; pos < len && y > 0; y--, pos++) {
                // 将 panel 中在同一行的字符放在一起，这样就不用真的把字符放在 panel 中
                chars[y][size[y]++] = s.charAt(pos);
            }
        }
        return toString(chars, numRows, size);
    }

    public static String toString(char[][] chars, int numRows, int[] size)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < size[i]; j++) {
                sb.append(chars[i][j]);
            }
        }
        return sb.toString();
    }
}
