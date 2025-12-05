package leetcode.greedy;

import java.util.Arrays;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        int n = gas.length;
        int total = 0;
        int[] diff = new int[n];
        int start = 0;

        for(int i = 0; i<n; i++){
            diff[i] = gas[i] - cost[i];
        }

        for(int i = 0; i<n; i++){
            total+=diff[i];
            if(total<0){
                total = 0;
                start = (i+1) % n;
            }
                
        }

        return total>=0 ? start : -1;
    }
}
