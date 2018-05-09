package com.chiyi.leetcode;

import java.lang.reflect.Array;

/**
 * @author chiyi
 * @date 2017/3/7
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        boolean carryFlag = false;
        for(int i=digits.length-1;i>=0;i--){
            digits[i] +=1;
            if(digits[i]==10){
                digits[i] -=10;
                carryFlag=true;
            }else {
                carryFlag = false;
                break;
            }
        }

        if(carryFlag){
            int[] newDigits = new int[digits.length+1];
            System.arraycopy(digits,0,newDigits,1,digits.length);
            newDigits[0] =1;
            return newDigits;
        }
        return digits;
    }
}
