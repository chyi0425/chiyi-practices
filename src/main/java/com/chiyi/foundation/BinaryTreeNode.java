package com.chiyi.foundation;

/**
 * @author chiyi
 * @date 2018/9/27.
 */
public class BinaryTreeNode {
    private int mData;
    private BinaryTreeNode mLeftChild;
    private BinaryTreeNode mRightChild;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int mData, BinaryTreeNode mLeftChild, BinaryTreeNode mRightChild) {
        this.mData = mData;
        this.mLeftChild = mLeftChild;
        this.mRightChild = mRightChild;
    }


    public int getmData() {
        return mData;
    }

    public void setmData(int mData) {
        this.mData = mData;
    }

    public BinaryTreeNode getmLeftChild() {
        return mLeftChild;
    }

    public void setmLeftChild(BinaryTreeNode mLeftChild) {
        this.mLeftChild = mLeftChild;
    }

    public BinaryTreeNode getmRightChild() {
        return mRightChild;
    }

    public void setmRightChild(BinaryTreeNode mRightChild) {
        this.mRightChild = mRightChild;
    }
}
