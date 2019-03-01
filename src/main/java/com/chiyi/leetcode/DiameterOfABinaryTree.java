package com.chiyi.leetcode;

/**
 * @author chiyi
 * @date 2019/3/1.
 */
public class DiameterOfABinaryTree {
}

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class Height {
    int h;
}

class BinaryTree {
    Node root;

    int diameterOpt(Node root, Height height) {
        Height lh = new Height();
        Height rh = new Height();

        if (root == null) {
            height.h = 0;
            return 0;
        }

        int lDiameter = diameterOpt(root.left, lh);
        int rDiameter = diameterOpt(root.right, lh);

        height.h = Math.max(lh.h, rh.h) + 1;

        return Math.max(lh.h + rh.h + 1, Math.max(lDiameter, rDiameter));
    }
}