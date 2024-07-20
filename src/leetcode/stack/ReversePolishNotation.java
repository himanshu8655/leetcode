package leetcode.stack;

import java.util.Stack;

public class ReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stk = new Stack<>();
		for (String token : tokens) {
			if (isNumeric(token))
				stk.push(Integer.parseInt(token));
			else
				stk.push(computeResults(stk, token));
		}
		return stk.peek();
	}

	public Integer computeResults(Stack<Integer> stk, String operation) {
		int num1 = stk.pop();
		int num2 = stk.pop();
		if (operation.equals("+"))
			return num2 + num1;
		else if (operation.equals("*"))
			return num2 * num1;
		else if (operation.equals("/"))
			return num2 / num1;
		else if (operation.equals("-"))
			return num2 - num1;
		else
			return null;
	}

	public boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
