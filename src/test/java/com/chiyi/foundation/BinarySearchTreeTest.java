package com.chiyi.foundation;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author chiyi
 * @date 2018/9/27.
 */
public class BinarySearchTreeTest {

    @Test
    public void insert() {
        BinarySearchTree binarySearchTree = new BinarySearchTree(new BinaryTreeNode());
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(8);
        binarySearchTree.insert(7);
        binarySearchTree.insert(9);
        binarySearchTree.insert(21);
    }
}