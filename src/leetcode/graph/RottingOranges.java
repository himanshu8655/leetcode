package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
	public static void main(String args[]) {
		int[][] grid = {
	            {2, 1, 1},
	            {0, 1, 1},
	            {1, 0, 1}
	        };
		orangesRotting(grid);
	}
	
	public static int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int time = 0;
        int[] count = new int[]{0};
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
                if(grid[i][j]==1)
                    count[0]++;
            }
        }
        while(!queue.isEmpty() && count[0]>0){
            int sz = queue.size();
            for(int i = 0; i<sz;i++){
                int[] dim = queue.poll();
                bfs(queue,grid,visited,dim[0]+1,dim[1],count);
                bfs(queue,grid,visited,dim[0]-1,dim[1],count);
                bfs(queue,grid,visited,dim[0],dim[1]+1,count);
                bfs(queue,grid,visited,dim[0],dim[1]-1,count);

            }
            time ++;
        }
        return count[0] == 0 ? time : -1;
    }
     static void bfs(Queue<int[]> queue,  int[][] grid, boolean[][] visited, int row, int col, int[] count){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || visited[row][col] || grid[row][col] == 0)
            return;
        visited[row][col] = true;
        queue.offer(new int[]{row,col});
        if(grid[row][col] == 1)
            count[0] --;
    }
}
