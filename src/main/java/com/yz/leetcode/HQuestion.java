package com.yz.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 *
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且每篇论文 至少 被引用 h 次。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 *
 * 示例 1：
 *
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 *      由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 * 示例 2：
 *
 * 输入：citations = [1,3,1]
 * 输出：1
 * @author yu.zh-neu
 * @create 2023-11-29 15:27
 */
public class HQuestion {

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
//        int hIndex = hIndex(citations);
        int hIndex = hIndex2(citations);
        System.out.println(hIndex);
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] < n - i) {
                return n - i - 1;
            }
        }
        return n;
    }


    public static int hIndex1(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    /**
     * 计数排序法
     * @param citations
     * @return
     */
    public static int hIndex2(int[] citations) {
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            // 超过h至少 h+1 次
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }
}
