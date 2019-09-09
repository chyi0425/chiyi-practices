package com.chiyi.foundation.rbtree;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 1. Each node is either red or black
 * 2. The root is black.
 * 3. All leaves(NIL) are black
 * 4. If a node is red, then both its children are black.
 * 5. Every path from a given node to any of its descendant NIL nodes contains the same number of black .
 * @param <T>
 */
public class RBTree<T extends Comparable<T>> {
    private final RBTreeNode<T> root;

    // node number
    private AtomicLong size = new AtomicLong(0);

    // in overwrite mode, all node's value can not has same value;
    // in non-overwrite mode,node can have same value, suggest don't use non-overwrite mode.
    private volatile boolean overrideMode = true;

    public RBTree() {
        root = new RBTreeNode<T>();
    }

    public RBTree(boolean overrideMode) {
        this();
        this.overrideMode = overrideMode;
    }

    public boolean isOverrideMode() {
        return isOverrideMode();
    }

    public void setOverrideMode(boolean overrideMode) {
        this.overrideMode = overrideMode;
    }

    /**
     * number of tree number.
     *
     * @return
     */
    public long getSize() {
        return size.get();
    }

    /**
     * get the root node
     *
     * @return
     */
    public RBTreeNode<T> getRoot() {
        return root.getLeft();
    }

    /**
     * add value to a new node, if this value exist in this tree,
     * if value exist, it will return the exist value. otherwise return null
     * if override mode is true, if value exist is the tree,
     * it will override the old value in the tree
     *
     * @param value
     * @return
     */
    public T addNode(T value) {
        RBTreeNode<T> t = new RBTreeNode<>(value);
        return addNode(t);
    }

    /**
     * find the value by give value(include key, key used for search,.
     * other field is not used,@see compare method). if this value not exist return null
     *
     * @param value
     * @return
     */
    public T find(T value) {
        RBTreeNode<T> dataRoot = getRoot();
        while (dataRoot != null) {
            int cmp = dataRoot.getValue().compareTo(value);
            if (cmp < 0) {
                dataRoot = dataRoot.getRight();
            } else if (cmp > 0) {
                dataRoot = dataRoot.getLeft();
            } else {
                return dataRoot.getValue();
            }
        }
        return null;
    }

    /**
     * remove the node by given value, if this value not exists in tree return null
     *
     * @param value include search key
     * @return the value contain in the removed node
     */
    public T remove(T value) {
        RBTreeNode<T> dataRoot = getRoot();
        RBTreeNode<T> parent = root;

        while (dataRoot != null) {
            int cmp = dataRoot.getValue().compareTo(value);
            if (cmp < 0) {
                parent = dataRoot;
                dataRoot = dataRoot.getRight();
            } else if (cmp > 0) {
                parent = dataRoot;
                dataRoot = dataRoot.getLeft();
            } else {
                if (dataRoot.getRight() != null) {
                    RBTreeNode<T> min = removeMin(dataRoot.getRight());
                    // x used for fix color balance.
                    RBTreeNode<T> x = min.getRight() == null ? min.getParent() : min.getRight();
                    boolean isParent = min.getRight() == null;

                    min.setLeft(dataRoot.getLeft());

                }
            }
        }
    }

    /**
     * find the successor node.
     * @param node current node's right node
     * @return
     */
    private RBTreeNode<T> removeMin(RBTreeNode<T> node) {
        // find the min code
        RBTreeNode<T> parent = node;
        while (node!=null&&node.getLeft()!=null){
            parent = node;
        }
        return null;
    }

    private T addNode(RBTreeNode<T> t) {
        return null;
    }
}
