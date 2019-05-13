package com.chiyi.leetcode;

public class ConstructStringFromBinaryTree {
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
        sb.append("(").append(tree2str(left)).append(")");
        if (right != null) {
            sb.append("(").append(tree2str(right)).append(")");
        }
        return sb.toString();
    }

}
