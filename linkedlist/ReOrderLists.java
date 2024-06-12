package leetcode.linkedlist;

public class ReOrderLists {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = reverse(slow);
        ListNode left = head;
        ListNode next_left;
        ListNode next_right;
        while(left!=null && right!=null){
            next_left = left.next;
            left.next = right;
            next_right = right.next;
            right.next = next_left;
            left = next_left;
            right = next_right;
        }
    }
    public ListNode reverse(ListNode head){
        ListNode node = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;

        }
        return node;
    }
}
