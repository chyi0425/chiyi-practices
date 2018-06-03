package com.chiyi.generics;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * 如果要从集合中读取类型T的数据，并且不能写入，可以使用 ? extends 通配符；(Producer Extends)
 * 如果要从集合中写入类型T的数据，并且不需要读取，可以使用 ? super 通配符；(Consumer Super)
 * 如果既要存又要取，那么就不要使用任何通配符。
 */
public class PECSTest {

    public static void main(String[] args) {
        List<? extends String> names = Lists.newArrayList("yiifaa");
        List<String> allNames = Lists.newArrayList("yiifee");
//        names.add("");
    }

}

class A {
}

interface B {

}

interface C {

}

class D<T extends A & B & C> {

}