package leetcode.graph;

public class SurroundedRegions {
    public static void main(String[] args) {

	 char[][] charArray = {
	            {'X', 'O', 'X', 'O', 'X', 'O'},
	            {'O', 'X', 'O', 'X', 'O', 'X'},
	            {'X', 'O', 'X', 'O', 'X', 'O'},
	            {'O', 'X', 'O', 'X', 'O', 'X'}
	        };
	 solve(charArray);
    }
    public static void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0;i<rows;i++){
            dfs(i, 0, board);
            dfs(i, cols-1, board);
        }
        for(int i = 0;i<cols;i++){
            dfs(0,i,board);
            dfs(rows - 1, i, board);
        }
        for(int i = 0;i<rows;i++)
            for(int j = 0;j<cols;j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'T')
                    board[i][j] = 'O';
            }
    }
    public static void dfs(int row, int col, char[][] board){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col] != 'O')
            return;
        board[row][col] = 'T';
        dfs(row + 1, col, board);
        dfs(row - 1, col, board);
        dfs(row, col + 1, board);
        dfs(row, col - 1, board);
    }
}
