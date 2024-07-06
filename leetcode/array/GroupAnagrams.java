package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
	}
	
 public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();
        
        for (String str : strs) {
            int[] char_count = new int[26];
            for (char c : str.toCharArray()) {
                char_count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int count : char_count) {
                sb.append('#');
                sb.append(count);
            }
            String key = sb.toString();
            
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(groups.values());
    }


}
