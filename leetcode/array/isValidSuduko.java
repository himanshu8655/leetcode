package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class isValidSuduko {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i<n; i++)
            for(int j = 0; j<m; j++){
                if(board[i][j] == '.') continue;
                if(!set.add(board[i][j]+"R"+i) || !set.add(board[i][j]+"C"+j) || !set.add(i/3+"<-R"+board[i][j]+"C->" +j/3)){
                    return false;
                }
            }
    return true;
    }
}
