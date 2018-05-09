package com.chiyi.util;

/**
 * @author chiyi
 */
public class MyMapTest {

    public static void main(String[] args) {
        MyMap<String,String> mm = new MyMap<>();
        Long beginTime = System.currentTimeMillis();
        for(int i=0;i<1000000;i++){
           mm.put(""+i,""+i*100);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("insert time-->"+(endTime-beginTime));

        beginTime = System.currentTimeMillis();
        mm.get(""+100000);
        endTime = System.currentTimeMillis();
        System.out.println("search time-->"+(endTime-beginTime));

        Integer i1 = new Integer(100);
        Integer i2 = new Integer(100);
        System.out.println(i1==i2);
    }

}
