package leetcode.array;

import java.util.HashSet;

public class LongestConsequenceSeq {
	 public int longestConsecutive(int[] nums) {
	        HashSet<Integer> set = new HashSet<>();
	        String s;
	        int res = 0;
	        for(int num : nums){
	            set.add(num);
	        }   
	        for(int num : nums){
	            if(set.contains(num-1)) continue;
	            int curr_longest = 1;
	            num++;
	            while(set.contains(num)){
	                curr_longest++;
	                num++;
	            }
	            res = Math.max(res, curr_longest);
	        }
	    return res;
	    }
}
