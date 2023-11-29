package com.yz.exercise;

/**
 * 二叉搜索树中删除节点
 * @author yu.zh-neu
 * @create 2023-08-02 16:28
 */
public class RemoveNodeProblem {
    public static void main(String[] args) {

    }

    private TreeNode deleteNdoe(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // 找到删除节点位置
        if (root.val < key) {
            return deleteNdoe(root.right, key);
        } else if (root.val > key) {
            return deleteNdoe(root.left, key);
        } else {
            // 左子树为空，返回右节点
            if (root.left == null) {
                return root.right;
            }
            // 右子树为空，返回左节点
            if (root.right == null) {
                return root.left;
            }
            // 左右字数都不会空，返回左子树最大节点
            TreeNode leftNode = root.left;
            while (leftNode.right != null) {
                leftNode = leftNode.right;
            }
            // 该节点没有右子树，删除节点，直接将原始节点的右子树改过来
            leftNode.right = root.right;
            return root.left;
        }
    }
}
