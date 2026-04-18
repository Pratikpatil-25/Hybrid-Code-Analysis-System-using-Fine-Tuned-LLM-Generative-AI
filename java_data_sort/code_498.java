class Solution {
    public ListNode insertionSortList(ListNode head) {
        
        ListNode dummy = new ListNode();
        ListNode prev = dummy;         ListNode current = head;         ListNode next;         
        while(current != null){
            next = current.next;
            
            while(prev.next != null && prev.next.val < current.val)
                prev = prev.next;             
            
            current.next = prev.next;
            prev.next = current;
            
            prev = dummy;             current = next;
        }
        
        return dummy.next;
    }
}