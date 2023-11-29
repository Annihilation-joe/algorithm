package com.yz.exercise;


/**
 * 存在一个按升序排列的链表，给你这个链表的头节点head，请你删除链表中所有存在数
 * 字重复情况的节点，只保留原始链表中没有重复出现的数字。返回同样按升序排列的结果
 * 链表
 *
 * @author yu.zh-neu
 * @create 2023-08-18 17:10
 */
public class DeleteDuplicatedNode {
    public static void main(String[] args) {
        ListNode head = ListNode.buildList(new int[]{1, 1, 1, 2, 3, 3, 4, 5, 6, 6, 7, 9});

        ListNode.printList(head);
        ListNode listNode = deleteDuplicates(head);
        System.out.println();
        ListNode.printList(listNode);

    }


    /**
     * 删除所有重复的节点
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            boolean isDuplicate = false;

            while (curr.next != null && curr.next.val == curr.val) {
                curr = curr.next;
                isDuplicate = true;
            }

            if (isDuplicate) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
