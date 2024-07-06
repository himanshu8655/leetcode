package leetcode.array;

import java.util.HashMap;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hmp = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums.length;i++){
            if(!hmp.containsKey(nums[i])){
                hmp.put(nums[i],1);
            }
            else return true;
        }
        return false;
    }
}
