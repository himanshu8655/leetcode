package leetcode.trie;

import java.util.HashMap;

public class ImplementTrie {
	 class Node{
	        boolean isEnd;
	        HashMap<Character,Node> nodes;
	        public Node(){
	            nodes = new HashMap<>();
	            isEnd = false;
	        }
	    }
	    Node root;
	    public ImplementTrie() {
	    root = new Node();
	    }
	    
	    public void insert(String word) {
	        Node temp = root;
	        char[] word_array = word.toCharArray();
	        for(Character c : word_array){
	           if(!temp.nodes.containsKey(c)){
	            temp.nodes.put(c,new Node());
	           }
	           temp = temp.nodes.get(c);
	        }
	        temp.isEnd = true;
	    }
	    
	    public boolean search(String word) {
	        Node temp = root;
	        char[] word_array = word.toCharArray();
	         for(Character c : word_array){
	            Node curr_node = temp.nodes.get(c);
	            if(curr_node == null)
	                return false;
	            temp = curr_node;
	         }
	         return temp.isEnd;
	    }
	    
	    public boolean startsWith(String prefix) {
	        Node temp = root;
	        char[] word_array = prefix.toCharArray();
	         for(Character c : word_array){
	            Node curr_node = temp.nodes.get(c);
	            if(curr_node == null)
	                return false;
	            temp = curr_node;
	         }
	         return true;
	    }
	}
