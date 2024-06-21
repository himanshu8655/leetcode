package leetcode.trie;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
	public static void main(String args[]) {
		WordDictionary d = new WordDictionary();
		d.addWord("at");
		d.addWord("and");
		d.addWord("an");
		d.addWord("add");
		d.search("a");
		d.addWord("bat");
		d.search(".at");

	}
	 class Node{
	        boolean isEnd;
	        HashMap<Character,Node> nodes;
	        public Node(){
	            nodes = new HashMap<>();
	            isEnd = false;
	        }
	    }
	    Node root;
	    public WordDictionary() {
	    root = new Node();
	    }
	    
	    public void addWord(String word)  {
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
	        return search("",word,temp,0);
	    }
	    public boolean search(String ans,String word,Node node, int idx){
	        if(idx == word.length())
	            return node.isEnd;
	        Character curr_char = word.charAt(idx);
	        if(curr_char == '.'){
	            if(node.nodes.isEmpty()) return false;
	            else
	            for (Map.Entry<Character, Node> entry : node.nodes.entrySet()){

	               if(search(ans + entry.getKey(), word, entry.getValue(), idx + 1))
	                return true;
	            }
	        }
	        else{
	            Node curr_node = node.nodes.get(curr_char);
	            if(curr_node!=null)
	            return search(ans + curr_char, word, curr_node, idx + 1);
	        }
	        return false;
	    }
	}
