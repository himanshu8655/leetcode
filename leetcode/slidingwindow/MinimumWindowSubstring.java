package leetcode.slidingwindow;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "acbba";
        String t = "aab";
        String a = minWindow(s, t);
        System.out.println(a);
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] freq = new int[128];
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i)]++;
        }

        int l = 0, r = 0, required = t.length(), res_len = Integer.MAX_VALUE;
        String res = "";

        while (r < s.length()) {
            char curr_char = s.charAt(r);
            if (freq[curr_char] > 0) {
                required--;
            }
            freq[curr_char]--;
            r++;

            while (required == 0) {
                if (r - l < res_len) {
                    res_len = r - l;
                    res = s.substring(l, r);
                }

                char l_char = s.charAt(l);
                freq[l_char]++;
                if (freq[l_char] > 0) {
                    required++;
                }
                l++;
            }
        }
        return res;
    }
}
