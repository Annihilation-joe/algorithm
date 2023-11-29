package com.yz.exercise;

import java.util.Stack;

/**
 * @author yu.zh-neu
 * @create 2023-08-01 15:51
 */
public class PostOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        postOrderTraversal(root);
    }

    private static void postOrderTraversal (TreeNode node) {

        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode peek = stack.peek();
                // 如果栈顶节点的右子树为空或者已经遍历过，那么可以将该节点出栈
                // 当我们将一个节点出栈时，我们需要判断其右子树是否已经遍历过了。
                // 如果已经遍历过，说明该节点的左右子树都已经遍历完毕，可以将该节点加入结果列表，并继续弹出栈顶节点。
                // 如果右子树还未遍历过，说明该节点的右子树还没有处理，需要将右子树作为新的根节点继续遍历。
                if (peek.right == null || peek.right == prev) {
                    System.out.println(peek.val);
                    prev = peek;
                    stack.pop();
                } else { // 否则，将栈顶节点的右子树作为新的根节点进行下一轮遍历
                    node = peek.right;
                }
            }
        }
    }

}
