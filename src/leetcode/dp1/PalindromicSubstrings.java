package leetcode.dp1;

public class PalindromicSubstrings {
	   public int countSubstrings(String s) {
	        int res = 0;
	        for(int i = 0; i<s.length(); i++){
	            res+= countPalindromes(i,i,s);
	            res+= countPalindromes(i,i+1,s);
	        }
	        return res;
	    }

	    public int countPalindromes(int left, int right, String s){
	        int count = 0;
	        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
	            left --;
	            right ++;
	            count ++;
	        }
	        return count;
	    }
}
