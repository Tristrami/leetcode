package problems.top100.接雨水;

// 42. 接雨水
// https://leetcode.cn/problems/trapping-rain-water/
public class TrappingRainWater
{
    public static void main(String[] args)
    {
        // 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        // 4, 2, 0, 3, 2, 5
        System.out.println(trap(new int[]{ 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }

    public static int trap(int[] height)
    {
        // dp[i] = dp[i - 1] + Σ trappedRain(height[i], height[j]), j 的范围是 [当前最高柱子的下标, i)
        // trappedRain(hi, hj) =
        // (min(hi, hj) - block) * (i - j - 1)  if hj > block && hi > block
        //  0                                   if i - j < 2 || hj <= block
        // block 代表 i, j 两根柱子之间的最高障碍高度
        // trappedRain 代表 i, j 两根柱子在高度大于 block 的部分能接到的雨水

        if (height == null || height.length < 3) return 0;
        int ans = 0, maxHeightIndex = 0, maxHeight = height[0];
        for (int i = 1; i < height.length; i++) {
            int block = 0;
            int trappedRain = 0;
            for (int j = i - 1; j >= maxHeightIndex; j--) {
                if (height[j] > block) {
                    if (i - j > 1 && height[i] > block) {
                        trappedRain += (Math.min(height[i], height[j]) - block) * (i - j - 1);
                    }
                    block = height[j];
                }
            }
            ans += trappedRain;
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxHeightIndex = i;
            }
        }
        return ans;
    }
}
