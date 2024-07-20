package leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generateParenthesis(n,"",res,0,0);
        return res;
    }
    public void generateParenthesis(int n,String ans,List<String> res, int open, int close){
    if(ans.length() == n*2)
    {
    res.add(ans);
    return;
    }
    if(open<n)
        generateParenthesis(n,ans+"(",res,open+1,close);
    if(close<open)
        generateParenthesis(n,ans+")",res,open,close+1);
    }
}
