package leetcode.dp2;

public class EditDistance {
    Integer memo[][];
    int m;
    int n;
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();
        memo = new Integer[m+1][n+1];
        return dp(0, 0, word1, word2);
    }
    public int dp(int i, int j, String s1, String s2){
        if(i==m || j==n)
            return (m-i)+(n-j);
        if(memo[i][j]!=null)
            return memo[i][j];
        if(s1.charAt(i) == s2.charAt(j))
            return memo[i][j] = dp(i+1, j+1, s1, s2);

        int del = dp(i+1, j, s1, s2);
        int replace = dp(i+1, j+1, s1, s2);
        int insert = dp(i, j+1, s1, s2);
        
        return memo[i][j] = 1 + Math.min(del, Math.min(replace,insert));
    }
}
