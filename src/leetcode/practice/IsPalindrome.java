package leetcode.practice;

public class IsPalindrome {

	public static void main(String[] args) {
		String str = "abA";
		System.out.println(isPalindrome(str));
	}
	
	public static boolean isPalindrome(String str) {
		str = str.toLowerCase();
		int n = str.length();
		 for(int i = 0; i<n/2; i++) {
			 if(str.charAt(i) != str.charAt(n-i-1)) {
				 return false;
			 }
		 }
		 return true;
	}

}
