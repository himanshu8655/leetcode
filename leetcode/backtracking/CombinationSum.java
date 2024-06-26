package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(0, 0, new ArrayList<>(), candidates, target, res);
		return res;
	}

	void dfs(int index, int sum, List<Integer> combinations, int[] candidates, int target, List<List<Integer>> res) {
		if (target == sum) {
			res.add(new ArrayList<>(combinations));
			return;
		}
		if (sum > target || index >= candidates.length)
			return;
		combinations.add(candidates[index]);
		dfs(index, sum + candidates[index], combinations, candidates, target, res);
		combinations.remove(combinations.size() - 1);
		dfs(index + 1, sum, combinations, candidates, target, res);

	}
}
