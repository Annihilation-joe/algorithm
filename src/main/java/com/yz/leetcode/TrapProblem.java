package com.yz.leetcode;

/**
 * 接雨水
 * @author yu.zh-neu
 * @create 2023-12-05 10:56
 */
public class TrapProblem {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap(height);
        System.out.println(trap);
    }

    private static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftTop = height[left];
        int rightTop = height[right];
        int res = 0;
        while (left < right){
            leftTop = Math.max(leftTop, height[left]);
            rightTop = Math.max(rightTop, height[right]);

            if (leftTop < rightTop) {
                res += leftTop - height[left++];
            }
            else {
                res += rightTop - height[right--];
            }
        }
        return res;
    }
}
