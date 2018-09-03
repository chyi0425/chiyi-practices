package com.chiyi.algorithms.sorting.elementary;

import org.junit.Test;

import static org.junit.Assert.*;

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
        StringBuilder  s1= new StringBuilder("good");
        StringBuilder  s2= new StringBuilder("bad ");
        exchange(s1,s2);
        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }

    public void exchange(StringBuilder s1,StringBuilder s2){
        s1 = s2;
        s2 = new StringBuilder();
        s1.append(" world");
        s2.append(" world");
    }

    @Test
    public void test1() {
        String  s1= new String("good");
        String  s2= new String("bad ");
        exchange1(s1,s2);
        System.out.println(s1.toString());
        System.out.println(s2.toString());


    }

    public void exchange1(String s1,String s2){
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


}