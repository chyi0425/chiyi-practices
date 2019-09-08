package com.chiyi.foundation.rbtree;

import java.util.concurrent.atomic.AtomicLong;

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

    public T find(T value) {
        RBTreeNode<T> dataRoot = getRoot();
        while (dataRoot != null) {

        }
    }

    private T addNode(RBTreeNode<T> t) {
        return null;
    }
}
