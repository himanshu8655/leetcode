package leetcode.intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
	
	public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <=1)
            return 0;
            
        Arrays.sort(intervals,(o1,o2)->o1[1]-o2[1]);
        int res = 0;
        int[] prev = intervals[0];
        
        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0]<prev[1]){
                res++;
            }
            else{
                prev = intervals[i];
            }
        }
        return res;
    }
}
