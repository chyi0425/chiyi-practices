package com.chiyi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chiyi
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(numRows ==0){
            return res;
        }

        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        res.add(pre);

        for(int i=2;i<=numRows;i++){
            List<Integer> cur = new ArrayList<>();
            // first
            cur.add(1);
            for(int j=0;j<pre.size()-1;j++){
                cur.add(pre.get(j)+pre.get(j+1));
            }
            // last
            cur.add(1);
            res.add(cur);
            pre = cur;
        }
        return res;
    }
}
