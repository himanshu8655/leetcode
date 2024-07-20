package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BTLevelOrderTraversal {
	 List<List<Integer>> res = new ArrayList<>();
	    
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        traverseTree(root,0);
	        return res;
	    }
	    public TreeNode traverseTree(TreeNode root, int level){
	        if(root == null) return null;
	        if(res.size()==level) res.add(new ArrayList<Integer>());
	        res.get(level).add(root.val);
	        traverseTree(root.left,level+1);
	        traverseTree(root.right,level+1);
	        return root;
	    }
}
