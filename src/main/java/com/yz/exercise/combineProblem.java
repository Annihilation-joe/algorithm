package com.yz.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yu.zh-neu
 * @create 2023-06-30 16:17
 */
public class combineProblem {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, 10, 5, 1, new ArrayList<>());
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public static void backtrack(List<List<Integer>> list, int n, int k, int start, List<Integer> temp) {
        if (k == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < n - k + 1; i ++) {
            temp.add(i);
            backtrack(list, n, k - 1, start + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
