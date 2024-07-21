package leetcode.graph;

public class NoOfIsland {

	public static void main(String[] args) {
		char[][] grid = { 
				{ '1', '1', '1', '1', '0' }, 
				{ '1', '1', '0', '1', '0' }, 
				{ '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		numIslands(grid);
	}

	public static int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					numIslands(i, j, grid);
					count++;
				}
			}
		return count;
	}

	public static void numIslands(int i, int j, char[][] grid) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '1')
			return;
		grid[i][j] = '2';
		numIslands(i + 1, j, grid);
		numIslands(i, j + 1, grid);

	}
}
