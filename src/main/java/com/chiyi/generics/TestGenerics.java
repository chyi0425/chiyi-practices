package com.chiyi.generics;

public class TestGenerics {
    /**
     * 泛型方法的语法包括一个类型参数列表(a list of type parameters)，里面的尖括号出现在方法的返回类型之前。对于静态泛型方法，类型参数部分必须出现在方法的返回类型之前。
     * @param p1
     * @param p2
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K,V> boolean compare(Pair<K,V> p1,Pair<K,V> p2){
        return p1.getKey().equals(p2.getKey())&&p1.getValue().equals(p2.getValue());
    }
}

class Pair<K,V>{
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}