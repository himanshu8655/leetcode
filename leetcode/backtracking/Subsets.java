package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public static void main(String[] args) {
		subsets(new int[] {1,2,3});
	}	
	
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0,nums, res,new ArrayList<Integer>());
        return res;
    }
    public static void dfs(int idx, int[] nums, List<List<Integer>> res, List<Integer> subset){
        if(nums.length == idx){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[idx]);
        dfs(idx + 1,nums,res,subset);
        subset.remove(subset.size() - 1);
        dfs(idx+1,nums,res,subset);

    }
}
