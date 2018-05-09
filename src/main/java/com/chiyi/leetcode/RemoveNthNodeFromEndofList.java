package com.chiyi.leetcode;

/**
 * @author chiyi
 * @date 2017/3/8
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode faster = head;
        ListNode slower = head;
        for(int i=0;i<n;i++){
            faster = head.next;
            if(faster == null){
                break;
            }
        }
        if(faster==null){
            head = head.next;
            return head;
        }
        while (faster.next!=null){
            faster = faster.next;
            slower = slower.next;
        }
        slower.next = slower.next.next;
        return head;
    }
}
