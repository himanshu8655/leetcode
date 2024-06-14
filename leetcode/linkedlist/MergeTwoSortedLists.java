package leetcode.linkedlist;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        ListNode res = new ListNode();
        ListNode head = res;
        while(list1!=null || list2!=null)
        {
            if(list1 == null) {               
                res.val = list2.val;
                res.next = list2.next;
                return head;
            }
            if(list2 == null) {
                res.val = list1.val;
                res.next = list1.next;
                return head;
            }

            if(list1.val>list2.val) {
                res.val = list2.val;
                list2 = list2.next;
                }

            else{
                    res.val = list1.val;
                    list1 = list1.next;
                }
            
            ListNode new_node = new ListNode();
            res.next = new_node;
            res = res.next;

        }
        return head;
        
    }   
}
