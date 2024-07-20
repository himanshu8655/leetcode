package leetcode.dp1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordBreak {
    public 	 Trie head = new Trie();

	public static void main(String[] args) {
		//wordBreak("goalspecial",Arrays.asList("go","goal","goals","special"));
	}
	public class Trie{

	    HashMap<Character,Trie> trie;
	    boolean isWord;

	    public Trie(){
	       trie = new HashMap<>();
	       isWord = false;
	    }
	}

	    public void addWordToTrie(String word) {
	        Trie temp = head;
	        for (char c : word.toCharArray()) {
	            Trie curr_trie = temp.trie.get(c);
	            if (curr_trie == null) {
	                curr_trie = new Trie();
	                temp.trie.put(c, curr_trie);
	            }
	            temp = curr_trie;
	        }
	        temp.isWord = true;
	    }

	    public boolean wordBreak(String s, List<String> wordDict) {
	        for(String word : wordDict){
	            addWordToTrie(word);
	        }
	        return dfs(s, 0, head, new Boolean[s.length()]);
	    }

	    public boolean dfs(String s, int idx, Trie head, Boolean[] memo){        
	        if(idx==s.length())
	            return true;

	        if (memo[idx] != null)
	            return memo[idx];

	        Trie temp = head;
	        for(int i = idx; i<s.length(); i++){
	            char c = s.charAt(i);
	            if(temp.trie.get(c) == null)
	                return memo[idx] = false;
	            temp = temp.trie.get(c);
	            if(temp.isWord && dfs(s, i+1, head, memo))
	                return memo[idx] = true;
	        }
	        return memo[idx] = false;
	    }	
}