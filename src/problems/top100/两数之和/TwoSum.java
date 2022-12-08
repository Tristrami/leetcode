package problems.top100.两数之和;

import java.util.Arrays;

// 1. problems.top100.两数之和
// https://leetcode.cn/problems/two-sum/?favorite=2cktkvj
public class TwoSum
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{ 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target)
    {
        int[] result = new int[2];
        int[] copy = Arrays.copyOf(nums, nums.length);
        byte[] visited = new byte[nums.length];
        Arrays.sort(copy);
        int left = 0, right = copy.length - 1;
        // 找出相加为 target 的两个数在 copy 数组中的下标
        while (left < right) {
            long sum = copy[left] + copy[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                break;
            }
        }
        // 在 nums 数组中根据两个数的值找到两个数的下标
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] == copy[left] || nums[i] == copy[right]) && visited[i] == 0) {
                result[size++] = i;
                visited[i] = 1;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
