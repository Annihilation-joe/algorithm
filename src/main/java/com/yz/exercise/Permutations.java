package com.yz.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 带有重复数字的全排列
 * @author yu.zh-neu
 * @create 2023-06-28 9:22
 */
public class Permutations {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 2};
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        //boolean数组，used[i]表示元素nums[i]是否被访问过
        boolean[] used = new boolean[nums.length];
        backtrack(result, used, new ArrayList<>(), nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public static void backtrack(List<List<Integer>> result, boolean[] used, List<Integer> temp, int[] nums) {
         if (temp.size() == nums.length) {
             result.add(new ArrayList<>(temp));
             return;
         }
         for (int i = 0; i < nums.length; i ++) {
//             if (temp.contains(nums[i])) {
//                 continue;
//             }
             if (used[i]) {
                 continue;
             }
             if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                 continue;
             }
             temp.add(nums[i]);
             used[i] = true;
             backtrack(result, used, temp, nums);
             used[i] = false;
             temp.remove(temp.size() - 1);
         }
    }
}
