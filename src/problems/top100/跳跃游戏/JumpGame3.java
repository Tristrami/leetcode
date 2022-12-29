package problems.top100.跳跃游戏;

import java.util.Arrays;

// 55. 跳跃游戏
// https://leetcode.cn/problems/jump-game/
public class JumpGame3
{
    public static void main(String[] args)
    {
        // 2, 3, 1, 1, 4
        // 3, 2, 1, 0, 4
        // 0
        // 2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6
        System.out.println(canJump(new int[]{ 1, 0, 1 }));
    }

    // 贪心，O(n)
    public static boolean canJump(int[] nums)
    {
        // 遍历 nums，更新从起点开始能跳的最远距离 longestDistance，例如在第一个位置时能跳的距离是 2，
        // 当我们选择跳 1 格，到了第二个位置，这时候能跳的距离变为了 3，所以从起点开始，能跳的最远距离就
        // 变成了 1 + 3 = 4，只要当遍历到最后一个位置时，longestDistance >= 第一个位置到最后一个位置
        // 的距离，那么就说明从起点可以跳到最后一个位置
        if (nums == null || nums.length == 0) return false;
        int longestDistance = 0;
        boolean ans = false;
        for (int i = 0; i < nums.length; i++) {
            // i 可以表示起点到当前位置的距离，如果这个距离比从起点最长能跳跃的距离还要大，说明从起点
            // 无法到达这个位置，进而后续的位置也同样无法到达
            if (i > longestDistance) return false;
            longestDistance = Math.max(i + nums[i], longestDistance);
        }
        return true;
    }
}
