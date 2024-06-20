package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permute {
	public static void main(String[] args) {
		permute(new int[] { 1, 2, 3 });
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		boolean check[] = new boolean[nums.length];
		dfs(new ArrayList<>(),check, nums, res);
		return res;
	}

	public static void dfs(List<Integer> permutation,boolean[] check ,int[] nums, List<List<Integer>> res) {
		System.out.println(permutation);
		if (nums.length == permutation.size()) {
			res.add(new ArrayList<Integer>(permutation));
			return;
		}
		for(int i = 0;i<nums.length;i++) {
			if(check[i]) continue;
			permutation.add(nums[i]);
			check[i] = true;
			dfs(permutation,check,nums,res);
			check[i] = false;
			permutation.remove(permutation.size() - 1);

		}
	}
}
