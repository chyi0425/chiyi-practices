package com.chiyi.generics;

public class Box<T> {
    private T t;

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }

    public <U extends Number> void inspect(U u) {
        System.out.println("T:" + t.getClass().getName());
        System.out.println("U:" + u.getClass().getName());
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(new Integer(10));
        //因为这里限定了inspect的方法泛型类型是Number或者其子类，所以当你传入一个String的时候会报错
//        integerBox.inspect("some text");
    }
}
