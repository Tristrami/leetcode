package problems.top100.跳跃游戏;

import java.util.Arrays;

// 55. 跳跃游戏
// https://leetcode.cn/problems/jump-game/
public class JumpGame
{
    public static void main(String[] args)
    {
        // 2, 3, 1, 1, 4
        // 3, 2, 1, 0, 4
        // 0
        System.out.println(canJump(new int[]{ 2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6 }));
    }

    // 超时
    public static boolean canJump(int[] nums)
    {
        if (nums == null || nums.length == 0) return false;
        return dfs(nums);
    }

    public static boolean dfs(int[] nums)
    {
        if (nums == null) {
            return false;
        } else if (nums.length == 1 || nums[0] >= nums.length - 1) {
            return true;
        } else if (nums[0] == 0) {
            return false;
        }
        boolean ans = false;
        for (int i = 1; i <= nums[0]; i++) {
            if (i < nums.length) {
                ans = ans || dfs(Arrays.copyOfRange(nums, i, nums.length));
            } else {
                break;
            }
        }
        return ans;
    }
}
