package com.yz.exercise;
import java.util.Arrays;
import java.util.Comparator;
/**
 * @author yu.zh-neu
 * @create 2023-06-20 10:44
 */


public class EnvelopeSorting {
    public static void main(String[] args) {
        int[][] envelopes = {
                {3, 10},
                {3, 5},
                {4, 8},
                {5, 7}
        };

        // 按照宽度升序排序，如果宽度相等则按照高度降序排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] env1, int[] env2) {
                if (env1[0] == env2[0]) {
                    return env2[1] - env1[1];
                } else {
                    return env1[0] - env2[0];
                }
            }
        });

        // 输出排序后的信封顺序
        for (int[] envelope : envelopes) {
            System.out.println("宽度：" + envelope[0] + "，高度：" + envelope[1]);
        }
    }
}

