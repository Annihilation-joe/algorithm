package com.yz.exercise;

import java.util.*;

/**
 * @author yu.zh-neu
 * @create 2023-07-28 11:28
 */
public class TreeNodeToString {
    private static int index = 0;
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode();
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode();
//        root.right.right = new TreeNode(7);
//        root.left.left.left = new TreeNode(8);

        Integer[] arr = { 1 , 2 , 3 , null , null, 4 , 5};
        TreeNode root = constructTree(arr);
        printTree(root);
        System.out.println();
        List<List<Integer>> levelOrder = levelOrder(root);
        for (List<Integer> integers : levelOrder) {
            System.out.println(integers);
        }
        System.out.println();

        String s = serialize(root);
        System.out.println(s);

        System.out.println();
        TreeNode treeNode = deserialize(s);
        printTree(treeNode);
    }

    private static TreeNode constructTree(Integer[] arr) {
        if (index >= arr.length || arr[index] == null) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(arr[index]);
        index++;
        root.left = constructTree(arr);
        root.right = constructTree(arr);
        return root;
    }

    private static String serialize(TreeNode root) {
//        if (root == null) {
//            return "#";
//        }
//        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private static TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }

    private static void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    private static TreeNode deserializeHelper(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeHelper(nodes);
        root.right = deserializeHelper(nodes);
        return root;
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    /**
     * BDS 层序遍历打印
     * @param root
     */
    private static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);

                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                } else {
                    list.add(null);
                }

            }
            result.add(list);

        }
        return result;
    }
}
