package problems.all.Z字形变换;

// 6. Z 字形变换
// https://leetcode.cn/problems/zigzag-conversion/
public class ZigzagConversion
{
    public static void main(String[] args)
    {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows)
    {
        if (s == null || s.length() < 2 || numRows < 2) {
            return s;
        }
        int len = s.length();
        // 创建一个二维数组 panel 用来存放字符的轨迹
        char[][] panel = new char[numRows][len];
        int pos = 0, x = 0;
        while (pos < len) {
            for (int y = 0; pos < len && y < numRows; y++, pos++) {
                panel[y][x] = s.charAt(pos);
            }
            x++;
            for (int y = numRows - 2; pos < len && y > 0; y--, x++, pos++) {
                panel[y][x] = s.charAt(pos);
            }
        }
        return convertPanelToString(panel, numRows, len);
    }

    public static String convertPanelToString(char[][] panel, int numRows, int numCols)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (panel[i][j] != '\u0000') {
                    sb.append(panel[i][j]);
                }
            }
        }
        return sb.toString();
    }
}
