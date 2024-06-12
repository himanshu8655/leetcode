package leetcode.slidingwindow;

import java.util.HashMap;

public class PermutationInString {

	public static void main(String args[]) {
		System.out.println(checkInclusion("abc", "cccccbabbbaaaa"));
	}

	public static boolean checkInclusion(String s1, String s2) {
		HashMap<Character, Integer> hmp = new HashMap<>();
		HashMap<Character, Integer> str_hmp = new HashMap<>();
		if (s1.length() > s2.length()) {
			return false;
		}
		for (int i = 0; i < s1.length(); i++) {
			Character curr_char = s1.charAt(i);
			Integer val = hmp.get(curr_char);
			if (val == null) {
				hmp.put(curr_char, 1);
			} else {
				hmp.put(curr_char, val + 1);
			}
		}
		for (int i = 0; i < s1.length(); i++) {
			Character curr_char = s2.charAt(i);
			Integer val = str_hmp.get(curr_char);
			if (val == null) {
				str_hmp.put(curr_char, 1);
			} else {
				str_hmp.put(curr_char, val + 1);
			}

		}
		if (hmp.equals(str_hmp)) {
			return true;
		}
		int l = -1;
		for (int i = s1.length(); i < s2.length(); i++) {
			l++;
			Character l_char = s2.charAt(l);
			Character r_char = s2.charAt(i);
			Integer l_char_freq = str_hmp.get(l_char);
			Integer r_char_freq = str_hmp.get(r_char);

			if (l_char_freq == null || l_char_freq == 1) {
				str_hmp.remove(l_char);
			} else {
				str_hmp.put(l_char, l_char_freq - 1);
			}

			if (str_hmp.get(r_char) == null) {
				str_hmp.put(r_char, 1);
			} else {
				str_hmp.put(r_char, str_hmp.get(r_char) + 1);
			}
			if (hmp.equals(str_hmp)) {
				return true;
			}
		}
		return false;
	}
}
