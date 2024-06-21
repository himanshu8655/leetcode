package leetcode.backtracking;

public class WordSearch {
	public static void main(String args[]) {
		
	}
    public static boolean exist(char[][] board, String word) {
        return checkIfWordExists(0,0,"",board,word);
    }
    public static boolean checkIfWordExists(int row, int col, String ans,char[][] board, String word){
        if(word == ans)
            return true;

        if(row<0 || row>=board[col].length || col<0 || col>board.length)
            return false;
        
        checkIfWordExists(row + 1, col, ans + board[row][col], board, word);
        checkIfWordExists(row - 1, col, ans + board[row][col], board, word);
        checkIfWordExists(row, col + 1, ans + board[row][col], board, word);
        checkIfWordExists(row, col - 1, ans + board[row][col], board, word);
        return false;

    }
}
