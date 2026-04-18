package newleetcode;

import dyc.ListNode;

public class SortList {
	public ListNode sortList(ListNode head) {
		ListNode nodeLeft = new ListNode(0);
		nodeLeft.next = head;

		ListNode node = null, nodeRight = null;
		int expectedLen = 1;
		node = genNode(nodeLeft, 1);
		nodeRight = genNode(nodeLeft, expectedLen);
		while (nodeLeft.next != null) {
						node = merge(node, expectedLen, nodeRight, expectedLen);
			expectedLen <<= 1;
			nodeRight = genNode(nodeLeft, expectedLen);
		}
				node = mergeNullEnd(node, expectedLen, nodeRight);
		return node;

	}

	ListNode genNode(ListNode sentinel, int elen) {
		ListNode ret = null;
		if (elen == 0) {
			return null;
		}
		if (elen == 1) {
			ret = sentinel.next;
			if (sentinel.next != null) {
				sentinel.next = sentinel.next.next;
			}
			return ret;
		}
		ListNode leftNodes = genNode(sentinel, elen / 2);
		if (sentinel.next == null) {
			ret = leftNodes;		} else {
			ListNode rightNodes = genNode(sentinel, (elen + 1) / 2);
			if (sentinel.next != null) {
				ret = merge(leftNodes, elen / 2, rightNodes, (elen + 1) / 2);
			} else {
				ret = mergeNullEnd(leftNodes, elen / 2, rightNodes);
			}
		}
		return ret;
	}

				ListNode mergeNullEnd(ListNode lnodes, int llen, ListNode rnodes) {
		ListNode ret = new ListNode(0), current = ret;
		ListNode l = lnodes, r = rnodes, smaller = null;
		while (llen > 0 && r != null) {
			if (l.val < r.val) {
				smaller = l;
				l = l.next;
				--llen;
			} else {
				smaller = r;
				r = r.next;
			}
			
			current.next = smaller;
			current = smaller;
			
		}
		if (r == null) {
			current.next = l;
			while (llen > 1) {
				l = l.next;
				--llen;
			}
			l.next = null;
		} else {
			current.next = r;
		}
		return ret.next;
	}

			ListNode merge(ListNode lnodes, int llen, ListNode rnodes, int rlen) {
		ListNode ret = new ListNode(0), current = ret;
		ListNode smaller = null;
		while (llen > 0 && rlen > 0) {

			if (lnodes.val < rnodes.val) {
				smaller = lnodes;
				lnodes = lnodes.next;
				--llen;
			} else {
				smaller = rnodes;
				rnodes = rnodes.next;
				--rlen;
			}
			current.next = smaller;
			current = smaller;
			
		}
		if (llen > 0) {
			current.next = lnodes;
		} else {
			current.next = rnodes;
		}
		return ret.next;
	}

	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(0);
		
		l1.next = l2;
		l2.next = l3;
		ListNode ret = new SortList().sortList(l1);
		return;

	}

}