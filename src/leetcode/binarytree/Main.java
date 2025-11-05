package leetcode.binarytree;

public class Main {

	public static void main(String[] args) {
		ListNode node = new ListNode(0);
		ListNode head = node;
		node.next = new ListNode(1);
		node = node.next;
		node.next = new ListNode(2);
		traverse(head);
		addElement(head);
		traverse(head);
	}

	private static void traverse(ListNode head) {
		while(head!=null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	private static void addElement(ListNode head) {
		while(head.val!=1) {
			head = head.next;
		}
		ListNode node = new ListNode(3);
		ListNode temp = head.next;
		head.next = node;
		node.next = temp;
		
		
	}

}

