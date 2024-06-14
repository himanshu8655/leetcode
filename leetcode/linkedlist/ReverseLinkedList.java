package leetcode.linkedlist;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev_node = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = prev_node;
            prev_node = head;
            head = temp;
        }
        return prev_node;
}
}
