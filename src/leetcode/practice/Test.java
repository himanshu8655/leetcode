package leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import leetcode.binarytree.ListNode;

	public class Test {
		
		public static void main(String args[]) {
			ListNode node = new ListNode(1);
			node.next = new ListNode(2);
			node.next.next = new ListNode(3);
			node.next.next.next = new ListNode(4);
			node.next.next.next.next = new ListNode(5);

			reorderList(node);
		}
		
	    public static void reorderList(ListNode head) {
	        ListNode slow = head;
	        ListNode fast = head.next;
	        while(fast!=null && fast.next!=null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        ListNode reverse_node = reverse(slow);
	        slow.next = null;
//	        printNode(head);
//	        printNode(reverse_node);
	        ListNode dummy_node = head;
	        while(dummy_node!=null){
	            ListNode next_dummy_node = dummy_node.next;
	             ListNode next_reverse_node = reverse_node.next;
	            dummy_node.next = reverse_node;
	            reverse_node.next = next_dummy_node;
	            dummy_node = next_dummy_node;
	            reverse_node = next_reverse_node;
	        }
	    }
	    public static void printNode(ListNode head){
	        System.out.println("================");
	        while(head!=null){
	            System.out.println(head.val);
	            head = head.next;
	        }
	    }
	    public static ListNode reverse(ListNode head){
	    	ListNode prev_node = null;
	        while(head!=null){
	            ListNode next_node = head.next;
	            head.next = prev_node;
	            prev_node = head;
	            head = next_node;
	        }

	        return prev_node;
	    }
	
}