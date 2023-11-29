package com.yz.exercise;

import java.util.*;

/**
 *
 * 题目
 * 在学校中，N 个小朋友站成一队第 i个小朋友的身高为 height[il第 个小朋友可以看到第一个比自己身高更高的小朋友
 * 那么i是的好朋友(要求: j> i)请重新生成一个列表对应位置的输出是每个小朋友的好朋友的位置
 * 如果没有看到好朋友请在该位置用 @代替小朋友人数范围  ~ 4000
 * 输入
 * 第一行输入N
 * N 表示有 N个小朋友第二行输入N个小朋友的身高 height[il都是整数
 * 8
 * 123 124 125 121 119 122 126 123
 * @author yu.zh-neu
 * @create 2023-09-08 16:26
 */
public class SweetFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strs = sc.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        // 栈处理
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = i;
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result).replaceAll("[\\[\\],]", ""));
    }
}
