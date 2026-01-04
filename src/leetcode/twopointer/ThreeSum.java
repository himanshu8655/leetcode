package leetcode.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

	public static void main(String[] args) {
		threeSum(new int[] {-1,0,1,2,-1,-4});
	}
	    public static List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        for(int i = 0; i<nums.length-2; i++){
	            int[] arr = twoSum(i+1, nums, -nums[i]);
	                    System.out.println(Arrays.toString(arr));
	            if(arr.length!=0)
	            res.add(new ArrayList<>(Arrays.asList(nums[i], arr[0], arr[1])));
	        }

	        return res;
	    }

	    public static int[] twoSum(int start, int[] nums, int target){
	        HashMap<Integer, Integer> hmp = new HashMap<>();
	        for(int i = start; i<nums.length; i++){
	            int num = nums[i];
	            int diff = target - num;
	            if(hmp.containsKey(diff)){
	                
	                return new int[]{hmp.get(diff), num};
	            }
	            hmp.put(diff, num);
	        }
	    return new int[]{};
	    }
	}
