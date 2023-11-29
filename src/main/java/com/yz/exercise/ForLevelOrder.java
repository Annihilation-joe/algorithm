package com.yz.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树层序遍历
 * @author yu.zh-neu
 * @create 2023-07-14 19:26
 */
public class ForLevelOrder {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);

        int level = levelOrder(root);
        System.out.println("二叉树层数：" + level);

    }

    private static int levelOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!(queue.isEmpty())) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.println(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level ++;
        }
        return level;
    }
}

