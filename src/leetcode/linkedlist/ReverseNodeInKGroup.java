package leetcode.linkedlist;

public class ReverseNodeInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy_head = head;
        ListNode dummy_head_prev = null;
        ListNode res = null;
        ListNode grp_end = null;
        while(true){
        ListNode nextKthNode = getKthNode(dummy_head,k);
        if(nextKthNode == null) return res==null ? head : res;
        grp_end = reverseList(dummy_head,k,nextKthNode.next);
        if(res == null) res = grp_end;
        if(dummy_head_prev!=null)
            dummy_head_prev.next = grp_end;
        dummy_head_prev = dummy_head;
        dummy_head = dummy_head.next;
        }
    }

    public ListNode reverseList(ListNode head , int k, ListNode nextKthNode){
        ListNode prev_node = nextKthNode;
        ListNode dummy_head = head;
        for(int i = 0;i<k;i++){
         ListNode temp = dummy_head.next;
            dummy_head.next = prev_node;
            prev_node = dummy_head;
            dummy_head = temp;
        }
        return prev_node;
    }

    public ListNode getKthNode(ListNode head, int k){
        while(k-1>0){
            if(head==null) return null;
            k--;
            head = head.next;
        }
        return head;
    }
}
