package leetcode.array;

import java.util.HashMap;

public class TwoSum {
	 public int[] twoSum(int[] nums, int target) {
	        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	        int n = nums.length;
	        for(int i = 0;i<n;i++){
	        int diff = target - nums[i];
	        String val = String.valueOf(map.get(diff));
	        if(val == "null"){
	            map.put(nums[i],i);
	        }
	        else{
	            return new int[]{Integer.parseInt(val),i};
	        }
	            
	        }  
	        return null;
	    }
}
