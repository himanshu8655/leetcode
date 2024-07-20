package leetcode.dp1;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int memo[] = new int[cost.length];
        return Math.min(dp(memo, cost, 0), dp(memo, cost, 1));
    }
    public int dp(int[] memo,int[] cost,int i){
        if(i>=cost.length)
            return 0;
        if(i == cost.length - 1)
            return cost[i];
        if(memo[i]!=0)
            return memo[i];
        memo[i] = cost[i] + Math.min(dp(memo, cost, i + 1), dp(memo, cost, i + 2));
        return memo[i];
    }
}
