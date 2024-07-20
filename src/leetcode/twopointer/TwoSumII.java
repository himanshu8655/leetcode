package leetcode.twopointer;

import java.util.HashMap;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> hmp = new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++){
            int num = numbers[i];
            if(hmp.containsKey(num)){
               int idx= hmp.getOrDefault(num,0);
                return new int[]{idx+1,i+1};
            }
            else{
                hmp.put(target - num,i);
            }
        }
        return new int[]{};
    }
}
