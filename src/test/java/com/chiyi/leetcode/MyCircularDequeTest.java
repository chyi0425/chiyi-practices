package com.chiyi.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author chiyi
 * @date 2019/3/12.
 */
public class MyCircularDequeTest {

    // ["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]
    //[[3],[1],[2],[3],[4],[],[],[],[4],[]]
    @Test
    public void testCircularDeque() {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertFront(9));
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.insertLast(2));
        System.out.println(myCircularDeque.insertFront(3));
        System.out.println(myCircularDeque.insertFront(4));
        System.out.println(myCircularDeque.isFull());
        System.out.println(myCircularDeque.deleteFront());
        System.out.println(myCircularDeque.insertFront(4));
        System.out.println(myCircularDeque.getFront());
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void insertFront() {
    }

    @Test
    public void insertLast() {
    }

    @Test
    public void deleteFront() {
    }

    @Test
    public void deleteLast() {
    }

    @Test
    public void getFront() {
    }

    @Test
    public void getRear() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void isFull() {
    }
}