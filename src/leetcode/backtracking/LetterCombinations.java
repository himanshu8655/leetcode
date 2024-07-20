package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
	
	public static void main(String args[]) {
		letterCombinations("234");
	}
	
	public static List<String> letterCombinations(String digits) {
        HashMap<Character,String> letters = new HashMap<>();
        List<String> res = new ArrayList<>();
        if(digits == null || digits.equals(""))
            return res;
        computeToLetter(letters);
        dfs(0,digits, res, letters,"");
        return res;
    }

    public static void dfs(int index, String digits, List<String> res, HashMap<Character,String> letters, String ans){
        if(index == digits.length())
            {
                res.add(ans);
                return;
            }
            String letter = letters.get(digits.charAt(index));
            for(int i = 0;i<letter.length();i++){
                dfs(index+1,digits,res,letters,ans+letter.charAt(i));
            }
    }
    
    public static void computeToLetter(HashMap<Character,String> letters){
        letters.put('2', "abc");
        letters.put('3', "def");
        letters.put('4', "ghi");
        letters.put('5', "jkl");
        letters.put('6', "mno");
        letters.put('7', "pqrs");
        letters.put('8', "tuv");
        letters.put('9', "wxyz");
    }
}
