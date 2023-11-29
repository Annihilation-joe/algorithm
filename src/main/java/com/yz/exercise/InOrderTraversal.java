package com.yz.exercise;

import java.util.Stack;

/**
 * 二叉树中序遍历非递归
 *
 * @author yu.zh-neu
 * @create 2023-08-01 9:34
 */
public class InOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        inOrderTraversal(root);
    }


    private static void inOrderTraversal(TreeNode node) {

        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
//            while (node != null) {
//                stack.push(node);
//                node = node.left;
//            }
//            if (!stack.isEmpty()) {
//                node = stack.pop();
//                System.out.println(node.val);
//                node = node.right;
//            }

            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.println(node.val);
                node = node.right;
            }
        }

    }
}
