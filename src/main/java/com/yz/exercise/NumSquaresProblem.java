package com.yz.exercise;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 找出最小的累加平方和
 *
 * @author yu.zh-neu
 * @create 2023-07-14 19:57
 */
public class NumSquaresProblem {
    public static void main(String[] args) {
        int i = numSquares(12);
        System.out.println(i);
    }

    private static int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        int level = 0;
        visited.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int digit = queue.poll();
                for (int j = 1; j <= n; j++) {
                    //子节点的值
                    int nodeValue = digit + j * j;
                    //nodeValue始终是完全平方数的和，当他等于n的
                    //时候直接返回
                    if (nodeValue == n) {
                        return level;
                    }
                    //如果大于n，终止内层循环
                    if (nodeValue > n) {
                        break;
                    }
                    if (!visited.contains(nodeValue)) {
                        queue.offer(nodeValue);
                        visited.add(nodeValue);
                    }
                }
            }
        }
        return level;
    }
}
