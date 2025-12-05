package leetcode.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class PartitionLabels {
	public boolean checkValidString(String s) {
        return dfs(s, 0, new Stack<Character>());
    }

    public boolean dfs(String s, int idx, Stack<Character> stk){
        if(idx == s.length()){
            return stk.isEmpty();
        }
        char curr_char = s.charAt(idx);
        if(curr_char == ')'){
            if(stk.isEmpty())
                return false;
            else{
                stk.pop();
                return dfs(s, idx+1, (Stack<Character>) stk.clone());
            }
        }

        else if(curr_char == '('){
            stk.push('(');
            return dfs(s, idx+1, (Stack<Character>) stk.clone());
        }
        else{
            boolean skip = dfs(s, idx+1, stk);
            stk.push('(');
            boolean open_paranthesis = dfs(s, idx+1, (Stack<Character>) stk.clone());
            if(!stk.isEmpty())
                stk.pop();

            if(stk.isEmpty())
                return false;
            stk.pop();
        boolean closed_paranthesis = dfs(s, idx+1, (Stack<Character>) stk.clone());
            stk.push('(');

            return open_paranthesis || skip || closed_paranthesis;
        }
    }
}
