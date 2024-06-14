package leetcode.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public class Bar{
	    private int index;
	    private int height;

	    public Bar(int index, int height){
	        this.height = height;
	        this.index = index;
	    }
	}

	    public int largestRectangleArea(int[] heights) {
	        Stack<Bar> stk = new Stack<Bar>();
	        int res = 0;
	        int last_idx = 0;
	        for(int i = 0; i<heights.length; i++){
	            last_idx = i;
	            while(!stk.isEmpty() && stk.peek().height>heights[i]){
	                Bar bar = stk.pop();
	                last_idx = bar.index;
	                int curr_area = (i - bar.index)*bar.height;
	                res = Math.max(res,curr_area);
	            }
	            stk.push(new Bar(last_idx,heights[i]));
	        }
	        while(!stk.isEmpty()){
	            Bar bar = stk.pop();
	                int curr_area = (heights.length - bar.index)*bar.height;
	                res = Math.max(res,curr_area);
	        }
	        return res;
	    }
}
