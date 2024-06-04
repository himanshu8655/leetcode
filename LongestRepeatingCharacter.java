package leetcode;

public class LongestRepeatingCharacter {

	public static int characterReplacement(String s, int k) {
		int l = 0;
		int char_occurence = 1;
		int res = 1;
		Character curr_char = s.charAt(0);
		Character next_char = s.charAt(0);
		int next_occurence = 0;
		for (int r = 1; r < s.length(); r++) {

			Character r_char = s.charAt(r);
			if (r_char == curr_char) {
				char_occurence++;
			} else {
				if (next_char == curr_char) {
					next_char = r_char;
					next_occurence = r;
				}
				if (r - l + 1 - char_occurence <= k) {
					// valid str
				} else {
					char_occurence = 1;
					l = next_occurence;
					curr_char = next_char;
					r = l;
				}
			}
			int len = Math.min(char_occurence + k, s.length());
			res = Math.max(res, len);
			if (r == s.length() - 1 && next_char != curr_char) {
				char_occurence = 1;
				l = next_occurence;
				curr_char = next_char;
				r = l;
			}
		}
		return res;
	}

	public static int optimizedCodeByGPT(String s, int k) {

		int[] count = new int[26]; // Array to store the frequency of each character
		int maxCount = 0; // The maximum frequency of a single character in the current window
		int maxLength = 0; // The length of the longest valid substring
		int l = 0; // Left pointer of the sliding window

		for (int r = 0; r < s.length(); r++) {
			char rChar = s.charAt(r);
			count[rChar - 'A']++;
			maxCount = Math.max(maxCount, count[rChar - 'A']);

			// If the number of characters to replace exceeds k, shrink the window from the
			// left
			if ((r - l + 1) - maxCount > k) {
				char lChar = s.charAt(l);
				count[lChar - 'A']--;
				l++;
			}

			// Calculate the maximum length of the valid substring
			maxLength = Math.max(maxLength, r - l + 1);
		}

		return maxLength;
	}
}
