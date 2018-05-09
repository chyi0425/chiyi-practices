package com.chiyi.jvm.optimize;

/**
 * @author chiyi
 */
public class PutInEden {

    public static void main(String[] args) {
        byte[] b1,b2,b3,b4; // 定义变量
        b1 = new byte[1024*1024]; // 分配1MB堆空间，考察空间的使用情况
        b2 = new byte[1024*1024];
        b3 = new byte[1024*1024];
        b4 = new byte[1024*1024];

        /**
         * -XX:+PrintGCDetails -Xmx20M -Xms20M
         * -XX:+PrintGCDetails -Xmx20M -Xms20M -Xmn6M
         */
    }
}
