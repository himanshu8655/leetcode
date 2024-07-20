package leetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PacificAtlanticWaterFlow {
	public static void main(String args[]) {
        HashSet<int[]> pacific = new HashSet<>();
        pacific.add(new int[] {1,2});
        System.out.println(pacific.contains(new int[] {1,2}));
	}
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<String> pacific= new HashSet<>();
        HashSet<String> atlantic= new HashSet<>();
        int row = heights.length;
        int col = heights[0].length;
        for(int i = 0; i<row;i++){
            dfs(i,0,heights, pacific, heights[i][0]);
            dfs(i,col - 1, heights,atlantic, heights[i][col-1]);
        }
        for(int i = 0; i<col;i++){
            dfs(0,i,heights, pacific, heights[0][i]);
            dfs(row-1,i, heights,atlantic, heights[row-1][i]);
        }
        for(int i = 0; i<row;i++)
            for(int j = 0;j<col;j++)
                if(atlantic.contains(i+"%"+j) && pacific.contains(i+"%"+j)){
                    List<Integer> lst = new ArrayList<>();
                    lst.add(i);
                    lst.add(j);
                    res.add(lst);
            }
    return res;
    }
    void dfs(int row, int col, int[][] heights, HashSet<String> visited, int previous){
        if(row<0 || col<0 || row>=heights.length || col>=heights[0].length || visited.contains(row+"%"+col) || heights[row][col]<previous)
            return;
        visited.add(row + "%" + col);
        dfs(row+1,col,heights,visited,heights[row][col]);
        dfs(row-1,col,heights,visited,heights[row][col]);
        dfs(row,col+1,heights,visited,heights[row][col]);
        dfs(row,col-1,heights,visited,heights[row][col]);

    }
}
