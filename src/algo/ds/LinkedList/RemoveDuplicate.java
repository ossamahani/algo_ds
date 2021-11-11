package algo.ds.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// 1,3,1,5 --> 1,3,5
		ListNode node = new ListNode(1, new ListNode(3, new ListNode(1, new ListNode(5, null))));
		node = removeDuplicate(node);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	private static ListNode removeDuplicate(ListNode node) {
		ListNode curr = node;
		ListNode prev = node;
		Set<Integer> seen = new HashSet<>();
		while (curr != null) {
			if (seen.contains(curr.val)) {
				prev.next = curr.next;
			}
			seen.add(curr.val);
			prev = curr;
			curr = curr.next;
		}
		return node;
	}
}
