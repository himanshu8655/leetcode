package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int[] res = new int[k];
        for(int num : nums){
            int val = freq.getOrDefault(num,0);
                freq.put(num,val+1);
        }
        int n = nums.length;
        List<Integer>[] freq_ele = new ArrayList[n+1];
        for(int i = 0; i<n+1; i++){
            freq_ele[i] = new ArrayList<Integer>();
        }
        for(Map.Entry<Integer, Integer> map: freq.entrySet()){
            freq_ele[map.getValue()].add(map.getKey());
        }
        int itr = 0;
            for(int i = 0; i<n+1; i++){
                for(Integer num : freq_ele[n-i]){
                    if(itr<k){
                        res[itr] = num;
                        itr++;
                    }
                    else
                        return res;
                    
                }
            }
        return res;
    }
}
