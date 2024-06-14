package leetcode.binarytree;

public class MaxDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left,right = 0;
        left = maxDepth(root.left);
        right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
