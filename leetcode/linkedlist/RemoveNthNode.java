package leetcode.linkedlist;

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        int mid = 1;
        int len = 2;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            mid++;
            len = (fast == null) ? mid * 2 - 1 : mid * 2;
        }
        int iteration = 0;
        ListNode start;
        if(n<mid){
                //mid
                iteration = len - n - mid;
                start = slow;
            }
            else{
                //start
                iteration = len - n -1;
                start = head;
            }
        if (iteration == -1) return head.next;
        System.out.println(start.val+"=="+iteration);
        for(int i = 0;i<iteration;i++){
            start = start.next;
        }
        ListNode temp = start.next.next;
        start.next = start.next.next;
        return head;
    }
}
