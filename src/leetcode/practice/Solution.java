package leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
	
	public static void main(String args[]) {
		Solution soln = new Solution();
		soln.lengthOfLongestSubstring("pwwkew");
		String[] str = new String[3];
		Arrays.sort(str,(a,b)->{
			return 0;
		});

		List<Integer> lst = new ArrayList<Integer>();
		lst.sort((a,b)->0);
	    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
	    minHeap.add(1);
	    minHeap.add(2);
	    System.out.print(minHeap);
	    System.out.print(minHeap.poll());
	    System.out.print(minHeap);
	}
	
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int max_len = 0;
        int curr_max = 0;
        Set<Character> seen = new HashSet<Character>();
        for(int j = 0; j<s.length(); j++){
            char curr_char = s.charAt(j);
            while(seen.contains(curr_char)) {
            	seen.remove(curr_char);
            	curr_max--;
            	i++;
            }
            curr_max++;
            seen.add(curr_char);
            max_len = Math.max(curr_max, max_len);
        }
        return max_len;
    }
}