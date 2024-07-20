package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {
	 public boolean isValidBST(TreeNode root) {
	        ArrayList<Integer> lst = new ArrayList<Integer>();
	        inOrderTraversal(root,lst);
	        return isSorted(lst);
	    }
	    public TreeNode inOrderTraversal(TreeNode root, List<Integer> lst){
	        if(root == null) return null;
	        inOrderTraversal(root.left,lst);
	        lst.add(root.val);
	        inOrderTraversal(root.right,lst);
	        return root;
	    }
	    public boolean isSorted( List<Integer> lst){
	        int n = lst.size();
	       for(int i = 0;i<n-1;i++){
	        if (lst.get(i) >= lst.get(i + 1)) {
	                return false;
	            }
	       }
	        return true;
	    }
}
