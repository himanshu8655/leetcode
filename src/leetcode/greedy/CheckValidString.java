package leetcode.greedy;

import java.util.Stack;

public class CheckValidString {

	public static void main(String[] args) {
		checkValidString("(*)");
	}
	
	    public static boolean checkValidString(String s) {
	        Stack<Character> stk = new Stack<>();
	        return dfs(s, 0, stk);
	    }

	    public static boolean dfs(String s, int idx, Stack<Character> stk){
	        if(idx == s.length()){
	            return stk.isEmpty();
	        }
	        char curr_char = s.charAt(idx);
	        if(curr_char == ')'){
	            if(stk.isEmpty())
	                return false;
	            else{
	                stk.pop();
	                return dfs(s, idx+1, stk);
	            }
	        }

	        else if(curr_char == '('){
	            stk.push('(');
	            return dfs(s, idx+1, stk);
	        }
	        else{
	            boolean skip = dfs(s, idx+1, stk);
	            stk.push('(');
	            boolean open_paranthesis = dfs(s, idx+1, stk);
	            if(!stk.isEmpty())
	                stk.pop();

	            if(stk.isEmpty())
	                return false;
	            stk.pop();
	            boolean closed_paranthesis = dfs(s, idx+1, stk);
	            stk.push('(');

	            return open_paranthesis || skip || closed_paranthesis;
	        }
	    }
	    }


