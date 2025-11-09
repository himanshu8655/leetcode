package leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
	      public int start, end;
	      public Interval(int start, int end) {
	          this.start = start;
	          this.end = end;
	      }
}
	      
public class MeetingRoomsII {
	public static void main(String args[]) {
		ArrayList<Interval> lst = new ArrayList<>();
		lst.add(new Interval(0, 40));
		lst.add(new Interval(5, 10));
		lst.add(new Interval(15, 20));
		minMeetingRooms(lst);
	}
	
	public static int minMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for(int i = 0; i<intervals.size(); i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        int max_ctr = 0;
        int i = 0;
        int j = 0;
        while(i<start.length) {
            if(start[i]<end[j]) {
                count++;
                max_ctr = Math.max(max_ctr, count);
                i++;
            }
            else{
                count--;
                j++;
            }
        }
        return max_ctr;
    }
}
