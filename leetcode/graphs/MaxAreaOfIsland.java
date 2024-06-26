package leetcode.graphs;

public class MaxAreaOfIsland {
	public static void main(String[] args) {
		int[][] array = {
			    {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			    {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
			    {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			    {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
			    {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
			    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
			    {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
			    {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
			};
		
		
		maxAreaOfIsland(array);
	}

	 public static int maxAreaOfIsland(int[][] grid) {
	        int count = 0;
	        for(int i = 0;i<grid.length;i++)
	            for(int j = 0;j<grid[0].length;j++){
	                if(grid[i][j]==1){
	                    count = Math.max(count, maxAreaOfIsland(i, j, grid));
	                }
	            }
	        return count;  
	    }
	    
	    public static int maxAreaOfIsland(int i, int j, int[][] grid){
	        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]==0)
	            return 0;
	        grid[i][j] = 0;

	        return (1+maxAreaOfIsland(i+1,j,grid)+
	                maxAreaOfIsland(i,j+1,grid)+
	                maxAreaOfIsland(i,j-1,grid)+
	                maxAreaOfIsland(i-1,j,grid));
	    }
}
