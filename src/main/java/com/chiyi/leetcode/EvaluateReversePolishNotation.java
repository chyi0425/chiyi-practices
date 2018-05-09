package com.chiyi.leetcode;

import java.util.Stack;

/**
 * @author chiyi
 * @date 2017/3/7
 */
public class EvaluateReversePolishNotation {
    private boolean isMatchCalc(String token){
        if("+".equals(token)||"-".equals(token)||"*".equals(token)||"/".equals(token)){
            return true;
        }
        return false;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
            if(isMatchCalc(tokens[i])){
                Integer paramB = stack.pop();
                Integer paramA = stack.pop();
                if("+".equals(tokens[i])){
                    stack.push(paramA+paramB);
                }
                if("-".equals(tokens[i])){
                    stack.push(paramA-paramB);
                }
                if("*".equals(tokens[i])){
                    stack.push(paramA*paramB);
                }
                if("/".equals(tokens[i])){
                    stack.push(paramA/paramB);
                }
            }else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
