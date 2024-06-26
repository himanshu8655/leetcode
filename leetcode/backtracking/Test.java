package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		solveNQueens(4);
	}

	  public static List<List<String>> solveNQueens(int n) {
	        List<List<String>> res = new ArrayList<>();
			List<char[][]> res_char = new ArrayList<>();
			char[][] ans = new char[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					ans[i][j] = '.';
				}
			solveNQueens(0, n, ans, res_char);
			for(char[][] board : res_char) {
	            List<String> lst = new ArrayList<>();
				for(int i = 0;i<n;i++) {
	                lst.add(new String(board[i]));					
				}
	            res.add(lst);
			}
			return res;
		}

		public static void solveNQueens(int row, int n, char[][] ans, List<char[][]> res) {
			if (row < 0 || row >= n)
				return;

			for (int i = 0; i < n; i++) {
				if (checkVertical(ans, row, i) && checkHorizontal(ans, row, i) && checkDiagonal(ans, row, i, n)) {
					ans[row][i] = 'Q';
					if (row == n - 1)
	                    res.add(Arrays.copyOf(ans,ans.length));
					solveNQueens(row + 1, n, ans, res);
				}
				ans[row][i] = '.';

			}

		}

		public static boolean checkVertical(char[][] ans, int row, int col) {
			for (int i = 0; i < row; i++) {
				if (ans[i][col] == 'Q')
					return false;
			}
			return true;
		}

		public static boolean checkHorizontal(char[][] ans, int row, int col) {
			for (int i = 0; i < col; i++) {
				if (ans[row][i] == 'Q')
					return false;
			}
			return true;
		}

		public static boolean checkDiagonal(char[][] ans, int i, int j, int n) {
			int row = i;
			int col = j;
			while (row >= 0 && col >= 0) {
				if (ans[row][col] == 'Q')
					return false;
				row--;
				col--;
			}
			row = i;
			col = j;
			while (row < n && col >= 0) {
				if (ans[row][col] == 'Q')
					return false;
				row++;
				col--;
			}
			row = i;
			col = j;
			while (row >= 0 && col < n) {
				if (ans[row][col] == 'Q')
					return false;
				row--;
				col++;
			}
			return true;
		}


}