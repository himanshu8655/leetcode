package leetcode.practice;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
		Practice obj = new Practice();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		obj.zigzagLevelOrder(root);
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