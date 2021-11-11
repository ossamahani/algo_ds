package algo.ds.LinkedList;

public class MergeSorted {
	
	public static ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode root = dummy;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				dummy.next = l1;
				l1 = l1.next;
			} else {
				dummy.next = l2;
				l2 = l2.next;
			}
			dummy = dummy.next;
		}
		
		if(l1 != null) {
			dummy.next = l1;
		} else {
			dummy.next  = l2;
		}
		return root.next;
	}

	public static ListNode mergeRec(ListNode l1, ListNode l2) {
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}

		if(l1.val < l2.val) {
			l1.next = mergeRec(l1.next, l2);
			return l1;
		}else {
			l2.next = mergeRec(l1, l2.next);
			return l2;
		}
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(5, new ListNode(7, new ListNode(9, new ListNode(11, null))));
		ListNode node2 = new ListNode(4, new ListNode(6, new ListNode(8, new ListNode(10, null))));
		ListNode result = merge(node1, node2);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

}
