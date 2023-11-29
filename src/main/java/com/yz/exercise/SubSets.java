package com.yz.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yu.zh-neu
 * @create 2023-06-30 10:18
 */
public class SubSets {

    public static void main(String[] args) {

        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }


    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        //注意这里没有写终止条件，不是说递归一定要有终止条件的吗，这里怎么没写，其实这里的终止条件
        //隐含在for循环中了，当然我们也可以写if(start>nums.length) rerurn;只不过这里省略了。
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            //做出选择
            tempList.add(nums[i]);
            //递归
            backtrack(list, tempList, nums, i + 1);
            //撤销选择
            tempList.remove(tempList.size() - 1);
        }
    }

}
