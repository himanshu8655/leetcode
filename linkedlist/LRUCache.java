package leetcode.linkedlist;

import java.util.HashMap;

public class LRUCache {
	  public class DLinkedList{
	        int val;
	        int key;
	        DLinkedList prev;
	        DLinkedList next;

	        public DLinkedList(int val, int key){
	            this.val = val;
	            this.key = key;
	        }
	    }

	    HashMap<Integer, DLinkedList> storage;
	    DLinkedList head = null;
	    DLinkedList tail = null;
	    int capacity;
	    int size = 0;
	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	        storage = new HashMap<Integer, DLinkedList>();
	        tail = new DLinkedList(0,0);
	        head = new DLinkedList(0,0);
	        tail.prev = head;
	        head.next = tail;
	    }
	     public void add(DLinkedList node){
	        size ++;
	        DLinkedList temp = head.next;
	        head.next = node;
	        node.prev = head;
	        node.next = temp;
	        temp.prev = node;
	        storage.put(node.key,node);
	    }
	    public void delete(DLinkedList node){
	        size --;
	        DLinkedList before = node.prev, after = node.next;
	        before.next = after;
	        after.prev = before;
	        storage.remove(node.key);
	    }
	    public int get(int key) {
	        DLinkedList node = storage.get(key);
	        //Key Not Found
	        if(node == null) return -1;
	        // Update Key to MRU
	        delete(node);
	        add(node);
	        return node.val;
	    }
	   
	    
	    public void put(int key, int value) {
	        DLinkedList node = storage.get(key);
	        if(node == null){
	            if(capacity == size){
	                delete(tail.prev);
	            }
	        
	            DLinkedList new_node = new DLinkedList(value,key);
	            add(new_node);
	        }
	        else {
	            node.val = value;
	            delete(node);
	            add(node);
	        }
	    }

}
