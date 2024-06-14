package leetcode.stack;

import java.util.Stack;

public class ValidParantheses {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        for(Character curr_char : s.toCharArray()){
            if(isOpenParantheses(curr_char))
                stk.push(curr_char);
            else if(!stk.isEmpty() && getOpenParantheses(curr_char) == stk.pop()) 
                continue;
            
            else 
                return false;
        }
        return stk.isEmpty();
    }
    public boolean isOpenParantheses(Character c){
        if(c == '[' || c == '(' || c == '{')
        return true;
        else
        return false;
    }
    public Character getOpenParantheses(Character c){
        if(c == ']')
            return '[';
        else if(c == ')')
            return '(';
        else if(c == '}')
            return '{';
        else
        return null;
    }
}
