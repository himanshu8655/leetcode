package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	public static void main(String args[]) {
		combinationSum2(new int[] {1,2,4,6},8);
	}
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(0,0,new ArrayList<Integer>(), candidates,target,res);
        return res;
    }
    public static void combinationSum2(int index, int sum, ArrayList<Integer> soln,int[] candidates,int target, List<List<Integer>> res){
        if(index == candidates.length && sum == target){
        	System.out.println(soln);
            res.add(new ArrayList<Integer>(soln));
            return;
        }
        if(sum>target || index>=candidates.length)  return;
        soln.add(candidates[index]);
        combinationSum2(index + 1, sum + candidates[index], soln, candidates, target, res);
        soln.remove(soln.size() -1);
        combinationSum2(index + 1, sum - candidates[index], soln, candidates, target, res);
    }
}
