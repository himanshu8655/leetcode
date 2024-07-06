package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class IslandAndTreasure {
    public static void main(String[] args) {
        int[][] grid = {
            {2147483647, -1, 0, 2147483647},
            {2147483647, 2147483647, 2147483647, -1},
            {2147483647, -1, 2147483647, -1},
            {0, -1, 2147483647, 2147483647}
        };
        islandsAndTreasure(grid);
    }
	static class Pair {
	int row;
	int col;

	public Pair(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public static void islandsAndTreasure(int[][] grid) {
	Queue<Pair> queue = new LinkedList<Pair>();
	boolean[][] visited = new boolean[grid.length][grid[0].length];
	int distance = 0;
	for (int i = 0; i < grid.length; i++) {
		for (int j = 0; j < grid[i].length; j++)
			if (grid[i][j] == 0) {
				queue.offer(new Pair(i, j));
				visited[i][j] = true;
			}
	}
    if(queue.isEmpty()) return;
	while (!queue.isEmpty()) {
        int sz = queue.size();
        for(int i = 0; i<sz; i++){
            Pair pair = queue.poll();
		    grid[pair.row][pair.col] = distance;
		    islandsAndTreasure(pair.row + 1, pair.col, grid,visited,queue);
		    islandsAndTreasure(pair.row - 1, pair.col, grid,visited,queue);
		    islandsAndTreasure(pair.row, pair.col + 1, grid,visited,queue);
		    islandsAndTreasure(pair.row, pair.col - 1, grid,visited,queue);
	}
    distance++;

}
}

public static void islandsAndTreasure(int i, int j, int[][] grid, boolean[][] visited, Queue<Pair> queue) {
	if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1 || visited[i][j]) {
		return;
	}
	visited[i][j] = true;
	queue.offer(new Pair(i,j));
	
}
}
