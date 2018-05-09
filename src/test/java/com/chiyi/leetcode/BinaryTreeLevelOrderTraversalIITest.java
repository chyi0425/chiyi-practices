package com.chiyi.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author chiyi
 * @date 2017/3/7
 */
public class BinaryTreeLevelOrderTraversalIITest {
    private TreeNode treeNode;

    @Before
    public void setUp() throws Exception {
        treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left=new TreeNode(15);
        right.right = new TreeNode(7);
        treeNode.right = right;
    }

    @Test
    public void levelOrderBottom() throws Exception {
        List<List<Integer>> excepted = new ArrayList<List<Integer>>();
        List<Integer> third = new ArrayList<Integer>();
        third.add(3);
        excepted.add(0,third);
        List<Integer> second = new ArrayList<Integer>();
        second.add(0,20);
        second.add(0,9);
        excepted.add(0,second);
        List<Integer> first = new ArrayList<Integer>();
        first.add(0,7);
        first.add(0,15);
        excepted.add(0,first);
        List<List<Integer>> actual = new BinaryTreeLevelOrderTraversalII().levelOrderBottom(treeNode);
        for(int i=0;i<3;i++){
            for(int j=0;j<excepted.get(i).size();j++){
                assertEquals(excepted.get(i).get(j),actual.get(i).get(j));
            }
        }
    }

}