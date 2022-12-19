package problems.top100.搜索旋转排序数组;

import java.util.Arrays;

// 33. 搜索旋转排序数组
// https://leetcode.cn/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray
{
    public static void main(String[] args)
    {
        // 4, 5, 6, 7, 1, 2, 3
        // 4, 5, 6, 7, 8, 9, 1, 2, 3
        // 4, 5, 6, 7, 0, 1, 2
        // 5, 1, 3
        System.out.println(search(new int[]{ 5, 1, 3 }, 3));
    }

    public static int search(int[] nums, int target)
    {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return target == nums[0] ? 0 : -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            // mid 两边必有一边升序，一边无序
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[l] <= nums[mid]) {
                // 如果 mid 左边的部分是升序，尝试在左边找
                if (nums[l] <= target && target <= nums[mid]) {
                    // 如果 target 在 [nums[l], nums[mid]] 范围内，就缩小右边界，在升序的（左边）部分查找
                    r = mid - 1;
                } else {
                    // 如果不在，就缩小左边界，尝试在右边无序（右边）的部分查找
                    l = mid + 1;
                }
            } else if (nums[mid] <= nums[r]) {
                // 如果 mid 右边的部分是升序，尝试在右边寻找
                if (nums[mid] <= target && target <= nums[r]) {
                    // 如果 target 在 [nums[mid], nums[r]] 范围内，缩小左边界，在升序（右边）的部分查找
                    l = mid + 1;
                } else {
                    // 如果不在，就缩小右边界，尝试在无序（左边）的部分查找
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
