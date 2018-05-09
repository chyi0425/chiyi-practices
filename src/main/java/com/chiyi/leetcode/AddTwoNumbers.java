package com.chiyi.leetcode;

/**
 * Created by chiyi on 2017/7/30.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode listNode=new ListNode(0);
        ListNode p1=l1,p2=l2,p3=listNode;
        while(p1!=null||p2!=null){
            if(p1!=null){
                carry+=p1.val;
                p1=p1.next;
            }
            if(p2!=null){
                carry+=p2.val;
                p2=p2.next;
            }
            p3.next=new ListNode(carry%10);
            p3=p3.next;
            carry/=10;
        }
        if(carry==1)
            p3.next=new ListNode(1);
        return listNode.next;
    }
}
