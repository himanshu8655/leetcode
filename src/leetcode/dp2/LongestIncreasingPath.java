package leetcode.dp2;

public class LongestIncreasingPath {
    Integer[][] memo;
    int m;
    int n;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        memo = new Integer[m+1][n+1];
        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLength = Math.max(maxLength, dp(matrix, i, j));
            }
        }
        
        return maxLength+1;
    }
    public int dp(int[][] matrix, int row, int col) {
        if(row>=m || col>=n || row<0 || col<0)
            return 0;
        
        if(memo[row][col] != null)
            return memo[row][col];
        
        int curr_no = matrix[row][col];
        int res = 0;
        int up = 0, down = 0, right = 0, left = 0;
        if(row+1<m && matrix[row+1][col]>curr_no)
            down = 1 + dp(matrix, row+1, col);
        if(col+1<n && matrix[row][col+1]>curr_no)
            right = 1 + dp(matrix, row, col+1);
        if(col-1>=0 && matrix[row][col-1]>curr_no)
            left = 1 + dp(matrix,row, col-1);
        if(row-1>=0 && matrix[row-1][col]>curr_no)
            up = 1 + dp(matrix, row-1, col);
        
        return memo[row][col] = Math.max(Math.max(Math.max(down,right),left),up);
    }

}
