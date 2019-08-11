package com.chiyi.algorithms.sorting.elementary;

import org.junit.Test;

public class ShellTest {

    @Test
    public void sort() {
        String parameters = "SORTEXAMPLE";
        char[] chars = parameters.toCharArray();
        Character[] characters = new Character[11];
        for(int i=0;i<characters.length;i++){
            characters[i] = chars[i];
        }
        Shell.sort(characters);
        System.out.println(characters);
    }

    @Test
    public void test() {
        System.out.println(Integer.getInteger("123"));
        StringBuilder  s1= new StringBuilder("good");
        StringBuilder  s2= new StringBuilder("bad ");
        exchangeSB(s1,s2);
        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }

    public static void exchangeSB(StringBuilder s1, StringBuilder s2){
        s1 = s2;
        s2 = new StringBuilder();
        s1.append(" world");
        s2.append(" world!");
    }

    @Test
    public void test1() {
        String  s1= new String("good");
        String  s2= new String("bad ");
        exchangeString(s1,s2);
        System.out.println(s1.toString());
        System.out.println(s2.toString());


    }

    public static void exchangeString(String s1, String s2){
        s1 = s2;
        s2 = new String();
        s1 +=" world";
        s2 +=" world";
    }


    @Test
    public void test2() {
        int  s1= 1;
        int  s2= 2;
        exchange3(s1,s2);
        System.out.println(s1);
        System.out.println(s2);
        String s = "searchNum_123";
        System.out.println(s.substring(10));
    }

    public void exchange3(int s1,int s2){
        s1 = s2;
        s2 = 3;
        s1 += 1;
        s2 += 1;
    }

    public static void main(String[] args) {
        String  s1= new String("good");
        String  s2= new String("bad ");
        exchangeString(s1,s2);
        System.out.println(s1.toString());
        System.out.println(s2.toString());

        StringBuilder  stringBuilder1= new StringBuilder("good");
        StringBuilder  stringBuilder2= new StringBuilder("bad ");
        exchangeSB(stringBuilder1,stringBuilder2);
        System.out.println(stringBuilder1.toString());
        System.out.println(stringBuilder2.toString());
    }


}