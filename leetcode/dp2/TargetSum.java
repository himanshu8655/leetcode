package leetcode.dp2;

public class TargetSum {
	public static void main(String args[]) {
		findTargetSumWays(new int[] {1,0}, 1);
	}
	
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums)
            sum+=num;
        return dfs(0, nums, target, sum);
    }
    public static int dfs(int idx, int[] nums, int target, int curr_sum){
        if(target == curr_sum)
            return 1;
        if(target>curr_sum)
            return 0;
        int res = 0;
        for(int i = idx; i<nums.length; i++){
            res+=dfs(i, nums, target, curr_sum - nums[i] - nums[i]);
        }
        return res;
    }
}
