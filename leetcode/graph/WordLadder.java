package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
	
	public static void main(String args[]) {
		List<String> lst = new ArrayList<>();
		lst.add("hot");
		lst.add("dot");
		lst.add("dog");
		lst.add("lot");
		lst.add("log");
		lst.add("cog");

		ladderLength("hit","cog",lst);
	}
	
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        HashMap<String, List<String>> hmp = new HashMap<>();
        int count = 1;
        for(String word : wordList){
            String[] combinations = getCombination(word);
            for(String combination : combinations)
                hmp.computeIfAbsent(combination, lst -> new ArrayList<String>()).add(word);
        }
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0;i<n;i++){
                String curr_word = queue.poll();
                for(String word_combo : getCombination(curr_word))
                    for(String word : hmp.getOrDefault(word_combo, new ArrayList<>())){
                        if(word.equals(endWord))
                            return count + 1;
                        if(!visited.contains(word)){
                            queue.offer(word);
                            visited.add(word);
                            }
                }
            }
            count ++;
        }
        return 0;
    }
	public static String[] getCombination(String word) {
		int n = word.length();
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			StringBuilder temp = new StringBuilder(word);
			temp.setCharAt(i, '*');
			words[i] = temp.toString();
		}
		return words;

	}
}
