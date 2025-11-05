package leetcode.intervals;

import java.util.ArrayList;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0)
            return new int[][]{newInterval};
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        
        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        int min_interval = newInterval[0];
        int max_interval = newInterval[1];
        while(i<intervals.length && intervals[i][0]<=newInterval[1]){
            min_interval = Math.min(min_interval, intervals[i][0]);
            max_interval = Math.max(max_interval, intervals[i][1]);
            i++;
        }
            res.add(new int[]{min_interval, max_interval});

        while(i<intervals.length){
            res.add(intervals[i]);
            i++;
        }

        int[][] arr = new int[res.size()][2];
        for(int j = 0; j<res.size(); j++){
            arr[j] = res.get(j);
        }
        return arr;
}
 

}
