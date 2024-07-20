package leetcode.dp1;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> lst = new ArrayList<>();
        for(Integer num : nums){
            if(lst.size() == 0 || lst.get(lst.size()-1)<num)
                lst.add(num);
            else{
                int i = lst.size()-1;
                while(i>=0 && lst.get(i)>=num){
                    i--;
                }
                lst.set(i+1,num);
            }
        }
    return lst.size();
    }
}
