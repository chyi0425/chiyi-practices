package com.chiyi.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chiyi
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if(s ==null){
            return null;
        }
        char[] charArray = s.toCharArray();
        int leftPoint = 0;
        int rightPoint = charArray.length-1;
        while (leftPoint<=rightPoint){
            if(isVowels(charArray[leftPoint])&&isVowels(charArray[rightPoint])){
                char temp = charArray[leftPoint];
                charArray[leftPoint] = charArray[rightPoint];
                charArray[rightPoint] = temp;
                leftPoint++;
                rightPoint--;
            }else if(isVowels(charArray[leftPoint])&&!isVowels(charArray[rightPoint])){
                rightPoint--;
            }else if(!isVowels(charArray[leftPoint])&&isVowels(charArray[rightPoint])){
                leftPoint++;
            }else {
                leftPoint++;
                rightPoint--;
            }
        }
        return new String(charArray);
    }

    private boolean isVowels(char param){
        Set<Character> vowelsSet = new HashSet<Character>();
        vowelsSet.add('A');
        vowelsSet.add('E');
        vowelsSet.add('I');
        vowelsSet.add('O');
        vowelsSet.add('U');
        vowelsSet.add('a');
        vowelsSet.add('e');
        vowelsSet.add('i');
        vowelsSet.add('o');
        vowelsSet.add('u');
        return vowelsSet.contains(param);
    }
}
