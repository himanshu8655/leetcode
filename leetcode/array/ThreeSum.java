package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
	
	public static void main(String args[]) {
	}
	
	 List<List<Integer>> res = new ArrayList<>();
	    public List<List<Integer>> threeSum(int[] nums) {
	        Arrays.sort(nums);
	        for(int i = 0; i<nums.length-2; i++){
	            if(i>0 && nums[i] == nums[i-1]) continue;
	            twoSum(i+1, -(nums[i]), nums);
	        }
	        return res;
	    }
	 public void twoSum(int start, int target, int[] nums) {
	        HashMap<Integer, Integer> hmp = new HashMap<>();
	        for (int i = start; i < nums.length; i++) {
	            int complement = target - nums[i];
	            if (hmp.containsKey(nums[i])) {
	                List<Integer> lst = new ArrayList<>();
	                lst.add(-target);
	                lst.add(nums[i]);
	                lst.add(complement);
	                res.add(lst);
	                // Skip duplicates
	                while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
	            } else {
	                hmp.put(complement, nums[i]);
	            }
	        }
	    }
	 
	 public List<List<Integer>> optimize(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        Arrays.sort(nums);
	        int n = nums.length;
	        for(int i = 0; i<n-2; i++){
	            if(i>0 && nums[i] == nums[i-1]) continue;
	            int left = i+1;
	            int right = n-1;
	            while(left<right) {
	                int sum = nums[left] + nums[right] + nums[i];
	                if(sum == 0) {
	                    res.add(Arrays.asList(nums[left],nums[right],nums[i]));
	                    left++;right--;
	                    while (left < right && nums[left] == nums[left - 1]) left++;
	                    while (left < right && nums[right] == nums[right + 1]) right--;
	                }
	                else if(sum<0)
	                    left++;
	                else
	                    right--;
	            }
	        }
	        return res;
	    }
}
