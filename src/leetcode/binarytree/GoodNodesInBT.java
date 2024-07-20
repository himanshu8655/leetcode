package leetcode.binarytree;

public class GoodNodesInBT {
	 public int goodNodes(TreeNode root) {
	        return traverseTree(root, Integer.MIN_VALUE);
	    }

	    public int traverseTree(TreeNode node, int maxSoFar) {
	        if (node == null) {
	            return 0;
	        }

	        int good = 0;
	        if (node.val >= maxSoFar) {
	            good = 1;
	        }

	        maxSoFar = Math.max(maxSoFar, node.val);

	        good += traverseTree(node.left, maxSoFar);
	        good += traverseTree(node.right, maxSoFar);

	        return good;
	    }
}
