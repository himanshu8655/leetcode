package leetcode.twopointer;

public class ValidPalindrome {
	public boolean isPalindrome(String s1) {
        int i = 0;
        int j = s1.length()-1;
        String s = s1.toLowerCase();
        while(i<j){
            char l_char = s.charAt(i);
            char r_char = s.charAt(j);
            if (!Character.isAlphabetic(l_char) && !Character.isDigit(l_char)){
                i++;
                continue;
            }
               if (!Character.isAlphabetic(r_char) && !Character.isDigit(r_char)){
                j--;
                continue;
            }
            if(l_char!=r_char) return false;
            i++;
            j--;
        }  
        return true;
    }
}
