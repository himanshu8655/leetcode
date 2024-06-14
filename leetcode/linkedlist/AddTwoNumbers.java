package leetcode.linkedlist;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        boolean carry = false;
        ListNode prev_node = null;

        while(l1!=null || l2!=null) {
                int sum = (l1!=null ? l1.val : 0) + (l2!=null ? l2.val : 0) + (carry ? 1 : 0);
                int ones_place = sum%10;
                int tens_place = sum/10;
                
                carry = (tens_place == 1)? true : false;
                ListNode ans_node = new ListNode(ones_place);
                
                if(prev_node!=null) prev_node.next = ans_node;
                else res = ans_node;
                prev_node = ans_node;
                if(l1!=null) l1 = l1.next;
                if(l2!=null) l2 = l2.next;
        }

        if(carry) prev_node.next = new ListNode(1);

        return res;
    }
}
