package leetcode.stack;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<Integer>();
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i = 0;i<n;i++){
            while(!stk.isEmpty() && temperatures[stk.peek()]<temperatures[i]){
                int idx = stk.pop();
                int temp_diff = i - idx;
                result[idx] = temp_diff;
            }
            stk.push(i);
        }
        return result;
    }
}
