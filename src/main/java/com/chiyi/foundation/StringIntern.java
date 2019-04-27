package com.chiyi.foundation;

/**
 * @author chiyi
 * @date 2018/9/11.
 */
public class StringIntern {

    public static void main(String[] args) {

        System.out.println(10.0/3*3);
    }

    public static void t1() {
        String s0 = "kvill";
        String s1 = "kvill";
        String s2 = "kv" + "ill";
        System.out.println(s0 == s1);
        System.out.println(s0 == s2);
    }

    public static void t2() {
        String s0 = "kvill";
        String s1 = new String("kvill");
        String s2 = "kv" + new String("ill");
        System.out.println(s0 == s1);
        System.out.println(s0 == s2);
        System.out.println(s1 == s2);
    }

    public static void t3() {
        // 创建了2个对象，第一个对象是"1"字符串存储在常量池中，第二个对象在JAVA Heap中的 String 对象。
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("2");
        String s4 = "11";
        s3.intern();
        System.out.println(s3 == s4);


    }

    public static void t4() {
        String str2 = new String("str") + new String("01");
        str2.intern();
        String str1 = "str01";
        System.out.println(str2 == str1);
    }

    public static void t5() {
        String str2 = new String("str") + new String("01");
        String str1 = "str01";
        str2.intern();
        System.out.println(str2 == str1);
    }
}
