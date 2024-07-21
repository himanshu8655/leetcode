package leetcode.dp2;

public class InterleavingString {
	int m;
    int n;
    int N;
    Boolean[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        N = s3.length();
        if (m + n != N) 
            return false;
        memo = new Boolean[m + 1][n + 1];
        return dp(0,0,s1,s2,s3);
    }
    public boolean dp(int i, int j, String s1, String s2, String s3){
        if(i == m && j == n && i+j == N)
            return true;

        if (memo[i][j] != null)
            return memo[i][j];

        if(i+j>=N)
            return false;
        
        char ch = s3.charAt(i+j);
        boolean res = false;

        if(i<m && s1.charAt(i) == ch)
            res = dp(i+1, j, s1, s2, s3);
        if(res)
            return memo[i][j] = true;
        if(j<n && s2.charAt(j) == ch)
            res = dp(i, j+1, s1, s2, s3);

        return memo[i][j] = res;
    }
}
