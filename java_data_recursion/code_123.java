class Solution
{

    private boolean flag = true;

    public ListNode swapPairs(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode start = head.next;
        recursion(head, null, null);
        return start;
    }

    private void recursion(ListNode node, ListNode pre1, ListNode pre2)
    {
        if (node == null)
        {
            return;
        }
        flag = !flag;
        if (flag)
        {
            pre1.next = node.next;
            node.next = pre1;
            if (pre2 != null)
            {
                pre2.next = node;
            }
            recursion(pre1.next, pre1, node);
        }
        else
        {
            recursion(node.next, node, pre1);
        }
    }
}