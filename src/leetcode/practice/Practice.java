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
		Map<String, String> lruCache = new LinkedHashMap<>(){
			@Override
			protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
				if(size()>2)
					return true;
				else return false;
			}
		};;
		lruCache.put("foo", "bar");
        lruCache.put("bar", "bar");
        lruCache.get("foo");
        lruCache.put("baz", "bar");

		Queue<Integer> q = new LinkedList<>();
		q.add(10);
		q.offer(20);
		q.offer(30);
		q.peek();   // 10
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.peek());

//		HttpClient client = HttpClient.newHttpClient();
//		HttpRequest req = HttpRequest.newBuilder().uri(URI.create("")).GET().build();
	}
	
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int sz = queue.size();
            LinkedList<Integer> level = new LinkedList<Integer>();
            for(int i=0;i<sz;i++){
                TreeNode node = queue.remove();
                    if(node!=null){
                        if(node.left!=null)
                            queue.add(node.left);
                        else if(node.right!=null)
                            queue.add(node.right);
                        if(leftToRight){
                            level.addLast(node.val);
                    }
                        else{
                            level.addFirst(node.val);
                    }
                }
            }
            System.out.print(level);
            res.add(level);
            leftToRight = !leftToRight;
        }
        return res;
    }
}