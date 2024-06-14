package leetcode.binarytree;

public class BalancedBinaryTree {
	 public boolean isBalanced(TreeNode root) {
	        if (root == null)  return true;
	        int height = depth(root);
	        if(height == -1)
	            return false;
	        
	        return true;
	    }
	    public int depth(TreeNode root){
	        if (root == null) return 0;
	        int left = depth(root.left);
	        int right = depth(root.right);
	        if(left == -1 || right == -1) return -1;
	        if (Math.abs(left - right) > 1) {
	            return -1;
	        }
	        return Math.max(left, right) + 1;
	    }
}
