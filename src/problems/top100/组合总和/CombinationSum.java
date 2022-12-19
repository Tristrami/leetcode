package problems.top100.组合总和;

import java.util.*;
import java.util.stream.Collectors;

// 39. 组合总和
// https://leetcode.cn/problems/combination-sum/
public class CombinationSum
{
    public static void main(String[] args)
    {
        // 2, 3, 6, 7
        // 7, 6, 3, 2
        System.out.println(combinationSum(new int[]{ 2, 3, 6, 7 }, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ans;
        // 逆序，这样就可以从大到小开始减，对于每个数字来说可以枚举完使用当前数字作为最大加数的所有情况，
        // 然后搜索下个数字时从 candidates 中去除当前数字，可以防止重复答案
        for (int l = 0, r = candidates.length - 1; l < r; l++, r--) {
            int t = candidates[l];
            candidates[l] = candidates[r];
            candidates[r] = t;
        }
        dfs(candidates, new ArrayList<>(candidates.length), ans, target);
        return ans;
    }

    public static void dfs(int[] nums, List<Integer> combination, List<List<Integer>> combinations, int currentResult)
    {
        if (currentResult == 0) {
            combinations.add(combination);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (currentResult >= nums[i]) {
                combination.add(nums[i]);
                // 只传 nums[i] 自己和后面的数，防止重复搜索 nums[i] 前面的数
                dfs(Arrays.copyOfRange(nums, i, nums.length), new ArrayList<>(combination), combinations, currentResult - nums[i]);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
