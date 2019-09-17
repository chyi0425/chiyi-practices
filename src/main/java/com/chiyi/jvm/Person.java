package com.chiyi.jvm;

/**
 * @author chiyi
 * @date 2019/6/28.
 */
public class Person {

    public String name;

    public String pwd;

    public int age;

    public Person(String name, String pwd, int age) {
        this.age = age;
        this.name = name;
        this.pwd = pwd;
    }


    public void setAge(int age) {
        this.age = age;
    }

//    @Override
//    public boolean equals(Object obj) {
//        return (this.name.equals(((Person) obj).name));
//
//    }
//
//    @Override
//    public int hashCode() {
//        return this.name.hashCode() + age;
//    }

}
