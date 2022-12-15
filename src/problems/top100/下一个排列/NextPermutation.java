package problems.top100.下一个排列;

import java.util.Arrays;

// 31. 下一个排列
// https://leetcode.cn/problems/next-permutation/
// 解析: https://leetcode.cn/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
public class NextPermutation
{
    public static void main(String[] args)
    {
        // 1 2 3 4 5
        // 2 3 5 4 1
        // 5 4 3 2 1
        // 1 3 2
        int[] nums = new int[]{ 1, 3 ,2 };
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums)
    {
        // 在 nums 中从后向前找到第一个上升数对 nums[i], nums[j] (i < j)，再从 nums 末尾开始在 (nums.length, j]
        // 范围中找到第一个满足 nums[i] < nums[k] 的数对，并交换两数
        int i, j, k;
        boolean isFound = false;
        for (j = nums.length - 1, i = j - 1; i >= 0; i--, j--) {
            if (nums[i] < nums[j]) {
                isFound = true;
                break;
            }
        }
        if (isFound) {
            for (k = nums.length - 1; k >= j; k--) {
                if (nums[i] < nums[k]) {
                    break;
                }
            }
            // 交换两数
            int t = nums[i];
            nums[i] = nums[k];
            nums[k] = t;
        }
        // 将 nums 中 [j, end) 范围的元素倒置，使 nums[j + 1] ... nums[end - 1] 为最小字典序排列
        for (int left = j, right = nums.length - 1; left < right; left++, right--) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
        }
    }
}
