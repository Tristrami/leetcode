package problems.top100.在排序数组中查找元素的第一个和最后一个位置;

import java.util.Arrays;

// 34. 在排序数组中查找元素的第一个和最后一个位置
// https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FindFirstAndLastPositionOfElementInSortedArray
{
    public static void main(String[] args)
    {
        // 1, 2, 3, 5, 6, 7, 7, 8, 9
        System.out.println(Arrays.toString(searchRange(new int[]{ 1 }, 1)));
    }

    public static int[] searchRange(int[] nums, int target)
    {
        // 进行两次二分查找，先找第一个出现的 target，再找最后一个出现的 target
        // 找第一个: 当 nums[mid] == target 时，不停止搜索，继续缩小右边界
        // 找第一个: 当 nums[mid] == target 时，不停止搜索，继续缩小左边界
        if (nums == null || nums.length == 0) return new int[]{ -1, -1 };
        if (nums.length < 2) return nums[0] == target ? new int[]{ 0, 0 } : new int[]{ -1, -1 };
        int l = 0, r = nums.length - 1, start = -1, end = -1;
        int[] ans = new int[2];
        // 找第一个出现的 target
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target < nums[mid]) {
                // 如果 target < nums[mid]，缩小右边界
                r = mid - 1;
            } else if (target > nums[mid]) {
                // 如果 target < nums[mid]，缩小左边界
                l = mid + 1;
            } else {
                // 如果 target == nums[mid]，记录 mid，并缩小右边界
                start = mid;
                r = mid - 1;
            }
        }
        ans[0] = start;
        l = 0; r = nums.length - 1;
        // 找最后一个出现的 target
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target < nums[mid]) {
                // 如果 target < nums[mid]，缩小右边界
                r = mid - 1;
            } else if (target > nums[mid]) {
                // 如果 target < nums[mid]，缩小左边界
                l = mid + 1;
            } else {
                // 如果 target == nums[mid]，记录 mid，并缩小右边界
                end = mid;
                l = mid + 1;
            }
        }
        ans[1] = end;
        return ans;
    }
}
