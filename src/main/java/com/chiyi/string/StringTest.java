package com.chiyi.string;

/**
 * @author chiyi
 * @date 2019/6/27.
 */
public class StringTest {
    public static void main(String[] args) {
//        String localPrefix = "297"; //1
        String localPrefix = new Integer(297).toString().intern(); //1

        String prefix = "297";      //2
        if (prefix == localPrefix)
        {
            System.out.println("Strings are equal" );
        }
        else
        {
            System.out.println("Strings are different");
        }

    }
}
