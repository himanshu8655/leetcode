package leetcode.linkedlist;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		ListNode head = null;
		ListNode dummy_head = null;
		ListNode prev_head = null;
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length,
				((node1, node2) -> Integer.compare(node1.val, node2.val)));
		for (ListNode node : lists) {
			if (node != null)
				minHeap.add(node);
		}
		while (minHeap.size() != 0) {
			ListNode node = minHeap.poll();
			ListNode res_node = new ListNode(node.val);
			if (prev_head != null)
				prev_head.next = res_node;
			else
				head = res_node;

			node = node.next;

			if (node != null)
				minHeap.offer(node);

			prev_head = res_node;
		}
		return head;
	}
}
