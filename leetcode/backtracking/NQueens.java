package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
	   public List<List<String>> solveNQueens(int n) {
	        List<List<String>> res = new ArrayList<>();
			char[][] ans = new char[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					ans[i][j] = '.';
				}
			solveNQueens(0, n, ans, res);
			return res;
		}

		public void solveNQueens(int row, int n, char[][] ans, List<List<String>> res) {
			if (row < 0 || row >= n)
				return;

			for (int i = 0; i < n; i++) {
				if (checkVertical(ans, row, i) && checkHorizontal(ans, row, i) && checkDiagonal(ans, row, i, n)) {
					ans[row][i] = 'Q';
					if (row == n - 1)
		                    res.add(construct(ans));
					solveNQueens(row + 1, n, ans, res);
				}
				ans[row][i] = '.';

			}

		}

		public boolean checkVertical(char[][] ans, int row, int col) {
			for (int i = 0; i < row; i++) {
				if (ans[i][col] == 'Q')
					return false;
			}
			return true;
		}

		public boolean checkHorizontal(char[][] ans, int row, int col) {
			for (int i = 0; i < col; i++) {
				if (ans[row][i] == 'Q')
					return false;
			}
			return true;
		}

		public boolean checkDiagonal(char[][] ans, int i, int j, int n) {
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
	        private List<String> construct(char[][] arr) {
	        List<String> res = new LinkedList<>();
	        for (int i = 0; i < arr.length; i++) {
	            res.add(new String(arr[i]));
	        }
	        return res;
	    }

	}