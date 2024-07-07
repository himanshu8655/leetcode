package leetcode.dp1;

public class ClimbingStairs {

	public int climbStairs(int n) {
		int[] memo = new int[n + 1];
		return dp(memo, 0, n);
	}

	public int dp(int[] memo, int curr_stair, int n) {
		if (curr_stair > n)
			return 0;
		if (curr_stair == n)
			return 1;
		if (memo[curr_stair] != 0)
			return memo[curr_stair];
		memo[curr_stair] = dp(memo, curr_stair + 1, n) + dp(memo, curr_stair + 2, n);
		return memo[curr_stair];
	}
}
