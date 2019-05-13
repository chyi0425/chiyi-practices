package com.chiyi.leetcode;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed==null||flowerbed.length==0){
            return false;
        }
        for(int index = 0;index<flowerbed.length&&n>0;index++){
            if(flowerbed[index]==0&&(index==0||flowerbed[index-1]==0)&&(index==(flowerbed.length-1) || flowerbed[index+1]==0) ){
                n--;
                flowerbed[index]=1;
            }

        }
        return n==0;
    }
}
