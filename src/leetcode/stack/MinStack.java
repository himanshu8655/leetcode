package leetcode.stack;

import java.util.Stack;

public class MinStack {
	class MinValPair {
		int val;
		int min_val;

		MinValPair(int val, int min_val) {
			this.val = val;
			this.min_val = min_val;
		}

		int getVal() {
			return val;
		}

		int getMinVal() {
			return min_val;
		}
	}

	Stack<MinValPair> min_stk;

	public MinStack() {
		min_stk = new Stack<MinValPair>();

	}

	public void push(int val) {
		MinValPair new_ele;
		if (min_stk.isEmpty()) {
			new_ele = new MinValPair(val, val);
		} else {
			MinValPair top_ele = min_stk.peek();
			new_ele = new MinValPair(val, Math.min(val, top_ele.getMinVal()));
		}
		min_stk.push(new_ele);
	}

	public void pop() {
		min_stk.pop();
	}

	public int top() {
		return min_stk.peek().getVal();
	}

	public int getMin() {
		return min_stk.peek().getMinVal();
	}

	/**
	 * Your MinStack object will be instantiated and called as such: MinStack obj =
	 * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
	 * param_4 = obj.getMin();
	 */
}
