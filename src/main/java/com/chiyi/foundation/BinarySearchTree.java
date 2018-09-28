package com.chiyi.foundation;

import edu.princeton.cs.algs4.BinarySearch;

/**
 * @author chiyi
 * @date 2018/9/27.
 */
public class BinarySearchTree {
    // root
    private BinaryTreeNode mRoot;

    public BinarySearchTree(BinaryTreeNode mRoot) {
        this.mRoot = mRoot;
    }

    /**
     * search data in tree
     *
     * @param data
     * @return
     */
    public BinaryTreeNode search(int data) {
        return search(mRoot, data);
    }

    /**
     * search data in the given tree
     *
     * @param node
     * @param data
     * @return
     */
    private BinaryTreeNode search(BinaryTreeNode node, int data) {
        if (node == null || node.getmData() == data) {
            return node;
        }
        if (data < node.getmData()) {
            return search(node.getmLeftChild(), data);
        } else {
            return search(node.getmRightChild(), data);
        }
    }

    /**
     * insert data into tree
     *
     * @param data
     */
    public void insert(int data) {
        // if tree is null, new
        if (mRoot == null) {
            mRoot = new BinaryTreeNode();
            mRoot.setmData(data);
            return;
        }
        searchAndInsert(null, mRoot, data);
    }

    /**
     * search and insert
     *
     * @param parent the parent need to bind
     * @param node   the compare node
     * @param data   data
     * @return
     */
    private BinaryTreeNode searchAndInsert(BinaryTreeNode parent, BinaryTreeNode node, int data) {
        // if the compare node is null,so this position is empty,insert
        if (node == null) {
            node = new BinaryTreeNode();
            node.setmData(data);
            if (parent != null) {
                if (data < parent.getmData()) {
                    parent.setmLeftChild(node);
                } else {
                    parent.setmRightChild(node);
                }
            }
            return node;
        }
        if (node.getmData() == data) {
            return node;
        } else if (data < node.getmData()) {
            return searchAndInsert(node, node.getmLeftChild(), data);
        } else {
            return searchAndInsert(node, node.getmRightChild(), data);
        }
    }

    public void delete(int data) {
        // if root is null or root is the data need to delete
        if (mRoot == null || mRoot.getmData() == data) {
            mRoot = null;
            return;
        }
        // find data's parent
        BinaryTreeNode parent = searchParent(data);
        if (parent == null) {
            return;
        }

        // find data's node
        BinaryTreeNode deleteNode = search(data);
        if (deleteNode == null) {
            // can not find it
            return;
        }

        // there maybe 4 result
        // 1. this is no child, then this node is leaf node
        if (deleteNode.getmLeftChild() == null && deleteNode.getmRightChild() == null) {
            // delete it
            deleteNode = null;
            if (parent.getmLeftChild() != null && parent.getmLeftChild().getmData() == data) {
                parent.setmLeftChild(null);
            } else {
                parent.setmRightChild(null);
            }
            return;
        } else if (deleteNode.getmLeftChild() != null && deleteNode.getmRightChild() == null) {
            // the node need to deleted only has left child,the left child need handle
            if(parent.getmLeftChild()!=null&&parent.getmLeftChild().getmData()==data){
                parent.setmLeftChild(deleteNode.getmLeftChild());
            }else {
                parent.setmRightChild(deleteNode.getmLeftChild());
            }
            deleteNode = null;
            return;
        }else if(deleteNode.getmRightChild() != null && deleteNode.getmLeftChild() == null){
            // the node need to deleted only has right child,the left child need handle
            if(parent.getmLeftChild()!=null&&parent.getmLeftChild().getmData()==data){
                parent.setmLeftChild(deleteNode.getmRightChild());
            }else {
                parent.setmRightChild(deleteNode.getmRightChild());
            }
            deleteNode = null;
            return;
        }else {
            // the node need to delete have both left and right children
            BinaryTreeNode copyOfDeleteNode = deleteNode;
            BinaryTreeNode heresNode = deleteNode.getmRightChild();
            if(heresNode.getmLeftChild()==null){
                heresNode.setmLeftChild(deleteNode.getmLeftChild());
            }else {
                while (heresNode.getmLeftChild()!=null){
                    copyOfDeleteNode = heresNode;
                    heresNode = heresNode.getmLeftChild();
                }
                copyOfDeleteNode.setmLeftChild(heresNode.getmRightChild());
                heresNode.setmLeftChild(deleteNode.getmLeftChild());
                heresNode.setmRightChild(deleteNode.getmRightChild());
            }
            if(parent.getmLeftChild()!=null&&parent.getmLeftChild().getmData()==data){
                parent.setmLeftChild(heresNode);
            }else{
                parent.setmRightChild(heresNode);
            }
        }
    }

    /**
     * find the father of the given data
     *
     * @param data
     * @return
     */
    private BinaryTreeNode searchParent(int data) {
        return searchParent(null, mRoot, data);
    }

    /**
     * find the father of the given data in given node
     *
     * @param parent
     * @param node
     * @param data
     * @return
     */
    private BinaryTreeNode searchParent(BinaryTreeNode parent, BinaryTreeNode node, int data) {
        if (node == null) {
            return null;
        }
        if (node.getmData() == data) {
            return parent;
        } else if (data < node.getmData()) {
            return searchParent(node, node.getmLeftChild(), data);
        } else {
            return searchParent(node, node.getmRightChild(), data);
        }
    }
}
