package leetcode.dp1;

public class LongestPalindromeSubstring {
	public String longestPalindrome(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			String s1 = findPalindrome(i, i, s);
			String s2 = findPalindrome(i, i + 1, s);
			if (s1.length() > s2.length() && s1.length() > res.length())
				res = s1;
			else if (s2.length() > s1.length() && s2.length() > res.length())
				res = s2;

		}
		return res;
	}

	public String findPalindrome(int num1, int num2, String s) {
		int n = s.length();
		int left = num1;
		int right = num2;
		StringBuilder res = new StringBuilder("");
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			if (left == right)
				res.append(s.charAt(left));
			else {
				res.insert(0, s.charAt(left));
				res.append(s.charAt(right));
			}
			left--;
			right++;
		}
		return res.toString();
	}
}
