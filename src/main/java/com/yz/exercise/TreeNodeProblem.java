package com.yz.exercise;

import java.util.*;

/**
 * @author yu.zh-neu
 * @create 2023-07-29 17:35
 */
public class TreeNodeProblem {


    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(3);
        root.left.left = new TreeNode1(4);
        root.left.right = new TreeNode1(5);
        root.right.left = new TreeNode1(6);
        root.right.right = new TreeNode1(7);
        mideOrder(root);
    }

    private static void mideOrderUn(TreeNode1 root) {
        if (root == null) {
            return;
        }
        mideOrderUn(root.left);
        System.out.println(root.val);
        mideOrderUn(root.right);
    }

    private static void mideOrder(TreeNode1 root) {
        if (root == null) {
            return;
        }
        TreeNode1 node = root;
        Stack<TreeNode1> stack = new Stack<>();
        while(!(stack.isEmpty()) || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode1 pop = stack.pop();
            System.out.println(pop.val);
            if (pop.right != null) {
                node = pop.right;
            }
        }
    }

}
class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    public TreeNode1 (int val) {
        this.val = val;
    }
}


