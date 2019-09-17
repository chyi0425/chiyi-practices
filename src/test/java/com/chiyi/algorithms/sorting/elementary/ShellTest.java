package com.chiyi.algorithms.sorting.elementary;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShellTest {
    @Test
    public void testBlocked() throws InterruptedException {
        class Counter {
            int counter;
            public synchronized void increase() {
                counter++;
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        Counter c = new Counter();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                c.increase();
            }
        }, "t1线程");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                c.increase();
            }
        }, "t2线程");
        t2.start();

        Thread.sleep(100); // 确保 t2 run已经得到执行
        assertTrue(t2.getState().equals(Thread.State.BLOCKED));
    }

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