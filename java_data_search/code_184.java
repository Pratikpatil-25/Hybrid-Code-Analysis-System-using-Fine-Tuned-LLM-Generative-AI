class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mid = findMiddleElement(head);
        TreeNode node = new TreeNode(mid.val);

                if (head == mid) {
            return node;
        }

                node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }

    private ListNode findMiddleElement(ListNode head) {
                ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

                while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

                if (prev != null) {
            prev.next = null;
        }
        return slow;
    }
}

class Solution {
    private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
                int size = findSize(head);
        this.head = head;

                return convertListToBST(0, size - 1);
    }

    private int findSize(ListNode head) {
        ListNode current = head;
        int length = 0;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }

    private TreeNode convertListToBST(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;

                TreeNode left = convertListToBST(l, mid - 1);

                TreeNode node = new TreeNode(this.head.val);
        node.left = left;

                this.head = this.head.next;

                node.right = convertListToBST(mid + 1, r);
        return node;
    }
}