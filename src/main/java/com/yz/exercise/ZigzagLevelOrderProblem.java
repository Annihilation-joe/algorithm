package com.yz.exercise;

import java.util.*;

/**
 * 层序遍历首尾相连锯齿形状打印
 * @author yu.zh-neu
 * @create 2023-08-02 16:44
 */
public class ZigzagLevelOrderProblem {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        zigzagLevelOrder(root);
    }

    private static void zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        boolean orderFlag = false;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.removeFirst();
                System.out.println(node.val);

                if (orderFlag) {
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                } else {
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }
                }
            }
            orderFlag = !orderFlag;
        }
    }
}
