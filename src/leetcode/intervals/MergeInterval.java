package leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        for(int i = 0 ; i < intervals.length ; i++ ){
            int start = intervals[i][0];
            int end = intervals[i][1];
            for(int j = i + 1 ; j < intervals.length ; j++ ){
                if(intervals[j][0] > end){
                    break;
                } else {
                    end = Math.max(end, intervals[j][1]);
                }
                i = j;
            }

            ans.add(new int[]{start, end});
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}
