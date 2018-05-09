package com.chiyi.leetcode;

import java.util.Arrays;

/**
 * @author chiyi
 */
public class ScrambleString {
    public boolean isScramble(String s1,String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1!=l2){
            return false;
        }
        if(l1==0){
            return true;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        if(l1==1){
            return  c1[0] == c2[0];
        }
        Arrays.sort(c1);
        Arrays.sort(c2);
        for(int i=0;i<l1;i++){
            if(c1[i]!=c2[i]){
                return false;
            }
        }

        boolean result = false;
        for(int i=1;i<l1&&!result;i++){
            String s11 = s1.substring(0,i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0,i);
            String s22 = s2.substring(i);

            result = isScramble(s11,s21)&&isScramble(s12,s22);
            if(!result){
                String s31 = s2.substring(0,l1-i);
                String s32 = s2.substring(l1-i);
                result = isScramble(s11,s32)&&isScramble(s12,s31);
            }
        }

        return result;
    }

    public boolean isScramble2(String s1,String s2){
        int len = s1.length();
        if(len!=s2.length()){
            return false;
        }
        if(len==0){
            return true;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        boolean[][][] result = new boolean[len][len][len];
        for(int i=0;i<len;++i){
            for(int j=0;j<len;++j){
                result[0][i][j] = (c1[i]==c2[j]);
            }
        }

        for(int k=2;k<=len;++k){
            for(int i=len-k;i>=0;--i){
                for(int j=len-k;j>=0;--j){
                    boolean r= false;
                    for(int m=1;m<k&&!r;++m){
                        r=(result[m-1][i][j]&&result[k-m-1][i+m][j+m])||(result[m-1][i][j+k-m] && result[k-m-1][i+m][j]);
                    }
                    result[k-1][i][j]=r;
                }
            }
        }
        return result[len-1][0][0];
    }
}
