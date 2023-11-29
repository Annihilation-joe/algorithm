package com.yz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个无重复元素的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的所有不同组合 ，并以列表形式返回。你可以按任意顺序返回这些组合。candidates 中的同一个数字可以无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7
 *
 * 输出：[[2,2,3],[7]]
 *
 * 解释：
 *
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 *
 * 7 也是一个候选， 7 = 7 。
 *
 * 仅有这两种组合。
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 *
 * 2 <= candidates[i] <= 40
 *
 * candidates 的所有元素 互不相同
 *
 * 1 <= target <= 40
 * @author yu.zh-neu
 * @create 2023-11-27 10:45
 */
public class CandidatesToTarget {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = candidatesSum(candidates, target);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }


    /**
     * 回溯算法
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> candidatesSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public static void backtrack (List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(res, path, candidates, target-candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
