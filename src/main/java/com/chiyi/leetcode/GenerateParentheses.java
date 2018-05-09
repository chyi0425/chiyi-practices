package com.chiyi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *  given n pairs of parentheses, write a function to geneate all combinations of well-formed parentheses
 *  For example, given n = 3, a solution set is:
 *  "((()))","(()())","(())()","()(())","()()()"
 * @author chiyi
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        if(n>0){
            char[] parentheses = new char[2*n];
            sovle(n,n,parentheses,result);
        }
        return result;
    }

    /**
     *
     * @param left the left parentheses can use
     * @param right the right parentheses can use
     * @param parentheses
     * @param result
     */
    private void sovle(int left, int right, char[] parentheses, List<String> result) {
        if(left<0 ||right<0||right<left){

        }else if(left==0 && right==0){
            result.add(new String(parentheses));
        }else {
            int idx = parentheses.length -left - right;
            parentheses[idx] = '(';
            sovle(left -1,right,parentheses,result);
            parentheses[idx] = ')';
            sovle(left,right-1,parentheses,result);
        }
    }
}
