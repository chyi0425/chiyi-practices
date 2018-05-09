package com.chiyi.jvm;

public class PrimitiveAndReference {
    public static void main(String[] args) {
        boolean test = true;
        System.out.println("1,"+test);
        test(test);
        System.out.println("3."+test);

        System.out.println("-----------------------------------------");
        StringBuffer sb = new StringBuffer("Hello");
        test2(sb);
        System.out.println(sb);
        System.out.println("-----------------------------------------");

        String string = "Hello";
        test3(string);
        System.out.println(string);
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
    }

    public static void test(boolean test){
        test = !test;
        System.out.println("2."+test);
    }

    public static void test2(StringBuffer str){
        str.append(",World!");
    }

    /**
     * 当执行str="World";时，其过程为：首先系统会自动生成一个新String对象，
     * 并把这个新对象的值设为"World!"，然后把这个对象的引用赋给str。当函数结束，str作用消失，原来的内存地址上的内容未加改变，所以打印结果仍然是Hello。
     * @param str
     */
    public static void test3(String str){
        str = "World";
    }
}
