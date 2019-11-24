package com.chiyi.leetcode;

/**
 * @author chiyi
 * @date 2019/5/13.
 */
public class Tree2Str {
    private static final String LEFT = "(";
    private static final String RIGHT = ")";

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(t.val));
        TreeNode left = t.left;
        TreeNode right = t.right;
        if (left == null && right == null) {
            return sb.toString();
        }
        sb.append(LEFT).append(tree2str(left)).append(RIGHT);
        if (right != null) {
            sb.append(LEFT).append(tree2str(right)).append(RIGHT);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode subLeft = new TreeNode(4);
        TreeNode right = new TreeNode(3);
        t.left = left;
        t.right = right;
        left.left = subLeft;
        Tree2Str tree2Str = new Tree2Str();
        tree2Str.tree2str(t);
    }
}
