package com.yz.exercise;

import java.util.Arrays;
import java.util.List;

/**
 * 反转链表两端除外的节点
 *
 * @author yu.zh-neu
 * @create 2023-08-24 15:03
 */
public class ReverseBetweenProblem {
    public static void main(String[] args) {
        ListNode head = ListNode.buildList(new int[]{1, 2, 3, 4, 5});

        ListNode.printList(head);

        ListNode node = reverseBetween(head, 2, 4);

        System.out.println();
        ListNode.printList(node);

    }

    private static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        for (int i = 0; i < n - m; i++) {
            ListNode tempNode = curr.next;
            curr.next = tempNode.next;
            tempNode.next = prev.next;
            prev.next = tempNode;
        }
        return dummy.next;
    }
}
