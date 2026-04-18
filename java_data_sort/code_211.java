"""
Performance:
Runtime: 30 ms, faster than 41.14% of Java online submissions for Insertion Sort List.
Memory Usage: 42 MB, less than 8.29% of Java online submissions for Insertion Sort List.
"""

class Solution {
   
   public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode tempOne = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            ListNode previous = null;
            ListNode current = tempOne;
            while (current != null && current.val < head.val) {
                previous = current;
                current = current.next;
            }
            ListNode tempTwo = new ListNode(head.val);
            if (previous == null) {
                tempTwo.next = current;
                tempOne = tempTwo;
            } else {
                previous.next = tempTwo;
                tempTwo.next = current;
            }
            head = head.next;
        }
        return tempOne;
    }
}