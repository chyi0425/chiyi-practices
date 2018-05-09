package com.chiyi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chiyi
 */
public class BullsandCows {
    public String getHint(String secret, String guess) {
        int aNum = 0;
        int bNum = 0;
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<secret.length();i++){
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if(a==b){
                aNum++;
            }else {
                if(map.containsKey(a)){
                    map.put(a,map.get(a)+1);
                }else {
                    map.put(a,1);
                }
            }
        }
        for(int i=0;i<guess.length();i++){
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if(a!=b){
                if(map.containsKey(b)){
                    bNum++;
                    if(map.get(b)==1){
                        map.remove(b);
                    }else {
                        map.put(b,map.get(b)-1);
                    }
                }
            }
        }
        return aNum+"A"+bNum+"B";
    }

    // 最经典的解法
    public String getHit2(String secret, String guess){
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
                if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
    public String getHint2(String secret, String guess){
        int countBull=0;
        int countCow =0;
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];

        for(int i=0; i<secret.length(); i++){
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);

            if(c1==c2)
                countBull++;
            else{
                arr1[c1-'0']++;
                arr2[c2-'0']++;
            }
        }

        for(int i=0; i<10; i++){
            // 2个数组取最小值，表示存在
            countCow += Math.min(arr1[i], arr2[i]);
        }

        return countBull+"A"+countCow+"B";
    }
}
