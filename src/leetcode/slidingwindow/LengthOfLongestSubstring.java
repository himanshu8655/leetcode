package leetcode.slidingwindow;

import java.util.HashMap;

public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		int j = 0;
		int max_len = 0;
		HashMap<Character, Integer> hmp = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (hmp.containsKey(c)) {
				if (hmp.get(c) >= j) {
					j = hmp.get(c) + 1;

				}
			}
			hmp.put(c, i);
			int curr_len = i - j + 1;
			max_len = Math.max(max_len, curr_len);

		}
		return max_len;
	}
}
