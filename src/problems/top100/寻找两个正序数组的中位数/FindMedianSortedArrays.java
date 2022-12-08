package problems.top100.寻找两个正序数组的中位数;

// 4. problems.top100.寻找两个正序数组的中位数
// https://leetcode.cn/problems/median-of-two-sorted-arrays/
public class FindMedianSortedArrays
{
    public static void main(String[] args)
    {
        int[] nums1 = new int[]{ 1, 3 };
        int[] nums2 = new int[]{ 2 };
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        // 先使用双指针法将两个有序数组合并为一个有序数组，再求中位数
        double ans;
        int[] nums = new int[nums1.length + nums2.length];
        int size = 0;
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums[size] = nums1[i];
                i++;
            } else {
                nums[size] = nums2[j];
                j++;
            }
            size++;
        }
        while (i < nums1.length) {
            nums[size] = nums1[i];
            size++;
            i++;
        }
        while (j < nums2.length) {
            nums[size] = nums2[j];
            size++;
            j++;
        }
        if (size % 2 == 0) {
            int index1 = size / 2 - 1;
            int index2 = index1 + 1;
            ans = (nums[index1] + nums[index2]) * 1.0 / 2;
        } else {
            ans = nums[size / 2 + 1 - 1];
        }
        return ans;
    }
}
