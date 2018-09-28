package com.chiyi.foundation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chiyi
 * @date 2018/9/12.
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer DecimalI = Integer.decode("+10");
        Integer OctI = Integer.decode("-010");
        Integer HexI = Integer.decode("-0x10");
        Integer HexI1 = Integer.decode("#10");
        System.out.println(DecimalI);
        System.out.println(OctI);
        System.out.println(HexI);
        System.out.println(HexI1);
        System.out.println(Integer.parseInt("99", 10));
        List<String> parentList = new ArrayList<String>();
        for(int i = 1; i < 50; i++){
            parentList.add(String.valueOf(i));
        }
        List<String> subList = parentList.subList(0, parentList.size());
        for(String s : subList){
            System.out.println(s);//output: 1, 2
        }
    }
}
