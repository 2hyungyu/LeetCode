package org.LeetCode;

import java.awt.*;

public class LinkedListLeetCode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

//    Input: head = [1,2,3,4,5], n = 2
//    Output: [1,2,3,5]
//    Input: head = [1], n = 1
//    Output: []
//    Input: head = [1,2], n = 1
//    Output: [1]
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode startNode = new ListNode();
        startNode.next = head;

        int size = 1;

        while (head.next != null) {
            head = head.next;
            size++;
        }

        int removeNode = size - n;
        head = startNode;
        for (int i = 0 ; i < removeNode ; i ++) {
            head = head.next;
        }
        head.next = head.next.next;
        return startNode.next;
    }

//    Input: head = [1,2,3,4,5]
//    Output: [5,4,3,2,1]
//    Input: head = [1,2]
//    Output: [2,1]
//    Input: head = []
//    Output: []
}
