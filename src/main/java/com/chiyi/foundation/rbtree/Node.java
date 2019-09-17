package com.chiyi.foundation.rbtree;

/**
 * @author chiyi
 * @date 2019/9/4.
 */
public class Node<T> {
    public T value;
    public Node<T> parent;
    public boolean isRed;
    public Node<T> left;
    public Node<T> right;
}
