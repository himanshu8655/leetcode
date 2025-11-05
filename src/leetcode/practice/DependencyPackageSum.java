package leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DependencyPackageSum {

	
	public static void main(String args[]) {
		minEatingSpeed(new int[] {3,6,7,11},8);
	}
		
	
	public static int minEatingSpeed(int[] piles, int h) {
        int left = Integer.MAX_VALUE;
        int right = 0;
        int res = Integer.MAX_VALUE;
        for(int pile : piles){
            left = Math.min(left, pile);
            right = Math.max(right, pile);
        }

        while(left<=right){
            int mid = left+(right-left)/2;
            int no_of_days = 0;
            for(int pile : piles){
                no_of_days+=Math.ceil((double) pile/mid);
            }
            if(no_of_days>h){
                left = mid+1;
                continue;
            }
            right = mid - 1;
            res = Math.min(no_of_days, res);
        }
                    return res;

}
}
