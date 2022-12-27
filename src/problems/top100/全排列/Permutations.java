package problems.top100.全排列;

import java.util.ArrayList;
import java.util.List;

// 46. 全排列
// https://leetcode.cn/problems/permutations/
public class Permutations
{
    public static void main(String[] args)
    {
        // 1, 2, 3
        System.out.println(permute(new int[]{ 1, 2, 3 }));
    }

    // 深搜回溯，O(N * N!)
    public static List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums == null || nums.length == 0) return permutations;
        dfs(nums, new ArrayList<>(), permutations, new boolean[nums.length], nums.length);
        return permutations;
    }

    public static void dfs(int[] nums, List<Integer> permutation, List<List<Integer>> permutations, boolean[] v, int n)
    {
        if (permutation.size() == n) {
            permutations.add(permutation);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!v[i]) {
                permutation.add(nums[i]);
                v[i] = true;
                dfs(nums, new ArrayList<>(permutation), permutations, v, n);
                permutation.remove(permutation.size() - 1);
                v[i] = false;
            }
        }
    }
}
