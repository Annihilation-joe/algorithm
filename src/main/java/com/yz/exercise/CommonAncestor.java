package com.yz.exercise;

import java.util.*;

/**
 * 寻找两个节点的最近公共祖先
 * @author yu.zh-neu
 * @create 2023-08-15 17:39
 */
public class CommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
//        TreeNode treeNode = lowestCommonAncestor1(root, root.left.left, root.right.right);
        TreeNode treeNode = lowestCommonAncestor2(root, root.left.left, root.right.right);
        System.out.println(treeNode.val);
    }

    /**
     * 递归解法
     * @param root
     * @return
     */
    private static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    /**
     * 非递归
     * @param root
     * @param p
     * @param q
     * @return
     */
    private static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        parent.put(root, null);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parent.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                queue.add(node.right);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = parent.get(p);
        }
        while (!set.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}
