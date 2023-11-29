package com.yz.exercise;

import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @author yu.zh-neu
 * @create 2023-08-01 17:27
 */
public class BSTProblem {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(5);
//        boolean validBST = isValidBST(root);
//        boolean validBST = isValidBST1(root);
        boolean validBST = isValidBST2(root);
        System.out.println(validBST);
    }

    /**
     * 非递归方式 中序遍历
     * @param node
     * @return
     */
    private static boolean isValidBST(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode temp = stack.pop();
                if (prev != null && temp.val <= prev.val) {
                    return false;
                }
                prev = temp;
                node = temp.right;
            }
        }
        return true;
    }

    /**
     * 递归方式 中序遍历
     * @param node
     * @return
     */
    private static boolean isValidBST1(TreeNode node) {
        TreeNode pre = null;
        return isValidBST1Sub(node, pre);
    }

    private static boolean isValidBST1Sub(TreeNode node, TreeNode pre) {
        if (node == null) {
            return true;
        }
        if (!isValidBST1Sub(node.left, pre)) {
            return false;
        }
        if (pre != null && node.val <= pre.val) {
            return false;
        }
        pre = node;
        if (!isValidBST1Sub(node.right, pre)) {
            return false;
        }
        return true;

    }

    /**
     * 递归 比较左子树的最大值和右子树的最小值
     * @param node
     * @return
     */
    private static boolean isValidBST2(TreeNode node) {
        return isValidBST2Sub(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBST2Sub(TreeNode node, long minValue, long maxValue) {
        if (node == null) {
            return true;
        }
        if (node.val >= maxValue || node.val <= minValue) {
            return false;
        }
        return isValidBST2Sub(node.left, minValue, node.val) && isValidBST2Sub(node.right, node.val, maxValue);
    }

}
