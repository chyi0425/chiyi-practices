package com.chiyi.jvm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chiyi
 * @date 2019/6/28.
 */
public class MemoryLeap {
    public static void main(String[] args) {

        Set<Person> set = new HashSet<Person>();
        Person p1 = new Person("唐僧", "pwd1", 25);
        Person p2 = new Person("孙悟空", "pwd2", 26);
        Person p3 = new Person("猪八戒", "pwd3", 27);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set.size());//输出3
        p3.setAge(2);//p3的hash值改变，
        set.remove(p3);//remove不掉
        set.add(p3);//添加成功！！
        System.out.println(set.size());//输出4

    }
}
