package com.chiyi.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 溢
 */
public class Product {
    List<String> parts = new ArrayList<>();

    public void add(String part){
        parts.add(part);
    }

    public void show(){
        System.out.println("\n产品创建 - - - - - -");
        for(String part : parts){
            System.out.println(part);
        }
    }
}
