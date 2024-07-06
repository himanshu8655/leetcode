package leetcode.array;

public class isAnagram {
	public boolean isAnagram(String s, String t) {
        int s_len = s.length();
        if (s_len != t.length()) {
            return false;
        }
        
        int[] freq = new int[26];
        for (int i = 0; i < s_len; i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}
