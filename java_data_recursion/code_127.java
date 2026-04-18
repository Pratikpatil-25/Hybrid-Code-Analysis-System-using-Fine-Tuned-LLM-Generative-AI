package com.lzhlyle.leetcode.self.no143;



public class ReorderList_Recursion {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        ListNode last = head, prev = null;

        while (last.next != null) {

            prev = last;

            last = last.next;

        }

        prev.next = null;

        last.next = head.next;

        head.next = last;

        reorderList(last.next);

    }

}