package leetcode.practice;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import leetcode.binarytree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Practice {
	
	public static void main(String args[]) {
		lengthOfLongestSubstring("pwwkew");
		characterReplacement("AAABABB", 1);
		maxProfit(new int[] {7,1,5,3,6,4});
	}
	
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = 0;
        int sell = 1;
        int n = prices.length;

        while(sell<n){
            if(prices[buy]>prices[sell]){
                buy = sell;
                sell++;
                continue;
            }
            maxProfit = Math.max(prices[sell] - prices[buy], prices[sell]);
            sell++;
        }
        return maxProfit;
    }
    
	   public static int characterReplacement(String s, int k) {
	        int result = 0;
	        int n = s.length();
	        for(int i = 0; i<n; i++){
	            int ctr = 0;
	            char distinctCharacter = s.charAt(i);
	            for(int j = i; j<n; j++){
	                
	                if(s.charAt(j) != distinctCharacter){
	                    ctr++;
	                }
	                if(ctr>k)
	                    break;
	                result = Math.max(j - i + 1, result);
	            }
	        }
	        return result;
	    }
	 public static int lengthOfLongestSubstring(String s) {
	        int leftPointer = -1;
	        int[] freq = new int[26];
	        int result = 0;
	        for(int i = 0; i<s.length(); i++){
	            char c = s.charAt(i);
	            if(freq[c - 'a'] == 0){
	                freq[c - 'a']++;
	                result = Math.max(result, i - leftPointer);
	            }
	            else{
	                if(leftPointer<s.length()-1){
	                leftPointer++;
	               char leftChar = s.charAt(leftPointer);
	               while(leftPointer<s.length() && leftChar!=c){
	                leftPointer++;
	                freq[leftChar - 'a']--;
	               }
	                }
	               
	               
	               
	            }
	        }

	        return result;
	    }
	
}