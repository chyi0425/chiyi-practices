package com.chiyi.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author chiyi
 * @date 2019/8/14.
 */
public class ReverseNodeListTest {
    ReverseNodeList reverseNodeList = new ReverseNodeList();

    @Test
    public void reverseList2() {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        reverseNodeList.reverseList2(head);
    }

    @Test
    public void testInt(){
        System.out.println(4114545 % 10);
        System.out.println(4114545 / 10);
    }

    @Test
    public void testIsPalindrome(){
        reverseNodeList.isPalindrome(121);
    }
}