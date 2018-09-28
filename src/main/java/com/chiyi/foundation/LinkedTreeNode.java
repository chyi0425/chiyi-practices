package com.chiyi.foundation;

import java.util.List;

/**
 * @author chiyi
 * @date 2018/9/27.
 */
public class LinkedTreeNode {
    // the data
    private Object mData;
    // the parent node
    private LinkedTreeNode mParent;
    // the children nodes
    private List<LinkedTreeNode> mChildNodeList;

    public LinkedTreeNode(Object mData, LinkedTreeNode mParent) {
        this.mData = mData;
        this.mParent = mParent;
    }

    public Object getmData() {
        return mData;
    }

    public void setmData(Object mData) {
        this.mData = mData;
    }

    public LinkedTreeNode getmParent() {
        return mParent;
    }

    public void setmParent(LinkedTreeNode mParent) {
        this.mParent = mParent;
    }

    public List<LinkedTreeNode> getmChildNodeList() {
        return mChildNodeList;
    }

    public void setmChildNodeList(List<LinkedTreeNode> mChildNodeList) {
        this.mChildNodeList = mChildNodeList;
    }
}
