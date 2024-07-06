package leetcode.backtracking;

public class WordSearch {
	public static void main(String args[]) {
		char[][] board = {
			    {'A', 'B', 'C', 'E'},
			    {'S', 'F', 'C', 'S'},
			    {'A', 'D', 'E', 'E'}
			};
	}
    public boolean exist(char[][] board, String word) {
        for(int i = 0;i<board.length;i++)
            for(int j = 0; j<board[i].length;j++){
                if(checkIfWordExists(i,j,0,board,word))
                    return true;
            }
        return false;    
        }
    public boolean checkIfWordExists(int row, int col, int idx,char[][] board, String word){
    	 if (idx == word.length()) {
             return true;
         }
        if(row<0 || col<0 || col>=board[0].length || row>=board.length || word.charAt(idx)!=board[row][col])
            return false;
        char temp = board[row][col];
        board[row][col] = '*';
        boolean found = checkIfWordExists(row + 1, col, idx+1, board, word) ||
        checkIfWordExists(row - 1, col, idx+1, board, word) ||
        checkIfWordExists(row, col + 1, idx+1, board, word) ||
        checkIfWordExists(row, col - 1, idx+1, board, word);
        board[row][col] = temp;
        return found;

    }
}
