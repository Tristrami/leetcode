package problems.top100.接雨水;

// 42. 接雨水
// https://leetcode.cn/problems/trapping-rain-water/
public class TrappingRainWater2
{
    public static void main(String[] args)
    {
        // 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        // 4, 2, 0, 3, 2, 5
        System.out.println(trap(new int[]{ 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }

    // 按列求雨水高度，使用动态规划记录每一列的左边最高柱子和右边最高柱子的高度
    public static int trap(int[] height)
    {
        // 求每一列能接到的雨水高度，然后再累加；对于第 i 列来说，能接到的雨水高度取决于其两边最高柱子的高度，具体来说就是，
        // ti = min(leftMaxHeight[i], rightMaxHeight[i]) - hi, 其中 leftMaxHeight 表示第 i 列左边最高柱子的高度，
        // rightMaxHeight 表示第 i 列右边最高柱子的高度，hi 表示当前第 i 列的柱子的高度
        // leftMaxHeight[i] = max(leftMaxHeight[i - 1], height[i])
        // rightMaxHeight[i] = max(rightMaxHeight[i + 1], height[i])
        // ans = ans + min(leftMaxHeight[i], rightMaxHeight[i]) - height[i]

        if (height == null || height.length < 3) return 0;
        int[] leftMaxHeight = new int[height.length];
        int[] rightMaxHeight = new int[height.length];
        int ans = 0;
        leftMaxHeight[0] = height[0];
        rightMaxHeight[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            leftMaxHeight[i] = Math.max(leftMaxHeight[i - 1], height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMaxHeight[i] = Math.max(rightMaxHeight[i + 1], height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i];
        }
        return ans;
    }
}
