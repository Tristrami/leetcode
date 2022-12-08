package problems.top100.盛最多水的容器;

// 11. 盛最多水的容器
// https://leetcode.cn/problems/container-with-most-water/
public class ContainerWithMostWater
{
    public static void main(String[] args)
    {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    // 双指针法
    public static int maxArea(int[] height)
    {
        // area = abs(x2 - x1 + 1) * min(h[1], h[2])
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1, maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
