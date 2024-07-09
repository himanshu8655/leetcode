package leetcode.dp1;

import java.util.HashSet;

public class PartitionEqualSubsetSum {
	 public boolean canPartition(int[] nums) {
	        HashSet<Integer> set = new HashSet<>();
	        int target = 0;
	        for(Integer num : nums){
	            target+= num;
	        }
	        if(target%2!=0)
	            return false;
	        target/= 2;
	        set.add(0);
	        for(Integer num : nums){
	            HashSet<Integer> temp = new HashSet<>();
	            for(Integer set_ele : set){
	                temp.add(set_ele+num);
	                temp.add(set_ele);
	                if(temp.contains(target))
	                    return true;
	            }
	            set = temp;
	        }
	        return false;
	    }
}
