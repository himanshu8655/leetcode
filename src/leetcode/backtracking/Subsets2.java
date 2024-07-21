package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
	public static void main(String[] args) {

	}
	List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(0,nums, new ArrayList<Integer>());
        return res;
    }
    public void backTrack(int idx, int[] nums, List<Integer> lst){
            res.add(new ArrayList<>(lst));
        for(int i = idx; i<nums.length; i++){
            if(i>idx && nums[i] == nums[i-1]) continue;
            lst.add(nums[i]);
            backTrack(i+1,nums,lst);
            lst.remove(lst.size() - 1);
        }
        return;
    }
}
