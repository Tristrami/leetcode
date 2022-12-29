package problems.top100.合并区间;

import java.util.Arrays;
import java.util.Comparator;

// 56. 合并区间
// https://leetcode.cn/problems/merge-intervals/
public class MergeIntervals
{
    public static void main(String[] args)
    {
        // { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 }
        // { 1, 4 }, { 2, 3 }
        int[][] ans = merge(new int[][]{ { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } });
        for (int[] arr : ans) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] merge(int[][] intervals)
    {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        int[][] ans = new int[intervals.length][2];
        int top = intervals.length - 1, size = 0;
        // 先按照区间的起始位置降序排序，起始位置相同时按照结束位置降序排序，因为这里是模拟堆栈，所以小的区间放在末尾
        Arrays.sort(intervals, (arr1, arr2) -> {
            if (arr1[0] < arr2[0]) {
                return 1;
            } else if (arr1[0] > arr2[0]) {
                return -1;
            } else {
                return Integer.compare(arr2[1], arr1[1]);
            }
        });
        while (top >= 0) {
            int[] interval = intervals[top--];
            if (top >= 0 && interval[0] <= intervals[top][0] && interval[1] >= intervals[top][1]) {
                // 如果当前区间完全包含下一个区间，那么就删除下一个区间，放入当前区间
                intervals[top] = interval;
            } else if (top >= 0 && interval[1] >= intervals[top][0]) {
                // 如果当前区间结束位置 >= 下一个区间起始位置，表示这两个区间有重合，需要合并，合并完以后再放入 intervals 中
                int[] interval2 = intervals[top--];
                intervals[++top] = new int[]{ interval[0], interval2[1] };
            } else {
                // 如果当前区间跟下一个区间没有重合，那就直接放到 ans 中
                ans[size++] = interval;
            }
        }
        return Arrays.copyOfRange(ans, 0, size);
    }
}
