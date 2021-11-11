package algo.ds.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {
	
	public static boolean hasCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		while(head != null) {  //  for (Node curr = n; curr != null; curr = curr.next) {
			if(set.contains(head)) {
				return true;
			}
			set.add(head);
			head = head.next;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		System.out.println(hasCycle(n1));
	}

}
