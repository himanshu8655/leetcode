package leetcode.dp2;

public class CoinChangeII {
	public static void main(String args[]) {
		int amount = 5;
		int[] coins = new int[] {1,2,5};
		change(amount, coins);
	}
    public static int change(int amount, int[] coins) {
        return dfs(amount, coins, new int[amount+1]);
    }
    public static int dfs(int amount, int[] coins, int[] dp) {
       dp[0] = 1;
            for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
	
}
