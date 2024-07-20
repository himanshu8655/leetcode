package leetcode.binarysearch;

import java.util.Arrays;

public class KokoEatingBanana {
	public static void main(String[] args) {
		int[] piles = {3,6,7,11};
		minEatingSpeed(piles,8);
	}
	
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int res = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            int curr_hr = getHours(piles,mid);

            if(curr_hr>h){
                low = mid +1;
            }
            else{                                
                high = mid-1;
            }
        }    
        return low;    
    }
    public static int getHours( int[] piles,int k){
        int hr = 0;
        for(int i = 0;i<piles.length;i++){
            hr+=Math.ceil((double) piles[i]/(double) k);
        }
        return hr;
    }
	}