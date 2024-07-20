package leetcode.linkedlist;

import java.util.HashMap;

public class DeepCopyLinkedList {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> hmp = new HashMap<>();
        Node prev_node = null;
        Node head_copy = head;
        while(head!=null){
         Node curr_node = hmp.getOrDefault(head,new Node(head.val));
         hmp.put(head, curr_node);

         if(prev_node!=null)
             prev_node.next = curr_node;

         if(head.random!=null){
         Node rnd_node = hmp.getOrDefault(head.random,new Node(head.random.val));
         curr_node.random = rnd_node;
         hmp.put(head.random,rnd_node);
        }
         prev_node = curr_node;
         head = head.next;
     }
        return hmp.get(head_copy);
     }
}
