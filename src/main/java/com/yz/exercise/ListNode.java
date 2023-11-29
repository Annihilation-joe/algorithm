package com.yz.exercise;

/**
 * 单向
 * 链表节点
 * @author yu.zh-neu
 * @create 2023-08-18 17:08
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 数组构造链表
     * @param nums
     * @return
     */
    public static ListNode buildList(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = cur.next;
        }
        return head;
    }

    /**
     * 打印链表
     * @param head
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
