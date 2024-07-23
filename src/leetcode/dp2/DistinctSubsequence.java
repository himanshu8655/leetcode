package leetcode.dp2;

public class DistinctSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    int m;
    int n;
    Integer[][] memo;
    public int numDistinct(String s, String t) {
        m = s.length();
        n = t.length();
        memo = new Integer[m+1][n+1];
        return dp(0,0,s,t);   
    }

    public int dp(int i, int j, String s1, String s2){
        if(j == n)
            return 1;
        if(i == m)
            return 0;
        if(memo[i][j]!=null)
            return memo[i][j];
        if(s1.charAt(i) == s2.charAt(j))
            memo[i][j] = dp(i+1, j+1, s1, s2)+ dp(i+1, j, s1, s2);
        else
            memo[i][j] = dp(i+1, j, s1, s2);
        return memo[i][j];
    }
}
