package problems.top100.旋转图像;

import java.util.Arrays;

// 48. 旋转图像
// https://leetcode.cn/problems/rotate-image/
public class RotateImage
{
    public static void main(String[] args)
    {
        // { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }
        int[][] matrix = new int[][]{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotate(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void rotate(int[][] matrix)
    {
        // 原来的第一行变为倒数第一列，原来的第一列变为第一行，通过这个变换方法确定每个元素的新的行号和列号即可
        // 也就是 rotatedMatrix[j][matrix.length - 1 - i] = matrix[i][j]
        if (matrix == null || matrix.length == 0) return;
        int[][] copy = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, matrix.length);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][matrix.length - 1 - i] = copy[i][j];
            }
        }
    }
}
