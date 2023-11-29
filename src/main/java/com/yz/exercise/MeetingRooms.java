package com.yz.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yu.zh-neu
 * @create 2023-06-27 9:24
 */
public class MeetingRooms {

    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        int minRooms = minMeetingRooms(intervals);
        System.out.println("最小需要的会议室数量为: " + minRooms);
    }

    public static int minMeetingRooms(int[][] intervals) {
        // 对会议按照开始时间进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // 使用最小堆来管理会议室的结束时间
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.offer(intervals[0][1]); // 将第一个会议的结束时间加入堆

        // 遍历剩下的会议
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前会议的开始时间晚于堆顶的会议结束时间，说明可以复用该会议室
            if (intervals[i][0] >= heap.peek()) {
                heap.poll(); // 移除堆顶的会议结束时间
            }

            heap.offer(intervals[i][1]); // 将当前会议的结束时间加入堆
        }

        return heap.size(); // 堆的大小即为所需的最小会议室数量
    }

}
