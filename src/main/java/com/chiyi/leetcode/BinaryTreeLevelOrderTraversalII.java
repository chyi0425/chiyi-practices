package com.chiyi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * @author chiyi
 * @date 2017/3/6
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null){
            return result;
        }
        helper(root,result,0);
        return result;
    }

    private void helper(TreeNode root, List<List<Integer>> result, int index) {
        int size = result.size();
        if(index==size){
            List<Integer> curList = new ArrayList<Integer>();
            curList.add(root.val);
            result.add(0,curList);
        }else {
            result.get(size-index-1).add(root.val);
        }
        if(root.left!=null){
            helper(root.left,result,index+1);
        }
        if(root.right!=null){
            helper(root.right,result,index+1);
        }
    }
}
