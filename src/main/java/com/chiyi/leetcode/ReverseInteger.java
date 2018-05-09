package com.chiyi.leetcode;

/**
 * @author chiyi
 * @date 2017/3/8
 */
public class ReverseInteger {
    public int reverse(int x) {
        long res = 0;
        while (x!=0){
            int s = x%10;
            res = res*10+s;
            x=x/10;
        }
        if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE){
            return 0;
        }
        return (int)res;
    }
}
