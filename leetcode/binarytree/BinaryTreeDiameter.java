package leetcode.binarytree;

public class BinaryTreeDiameter {
	int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findDepth(root);
        return diameter;
    }
    public int findDepth(TreeNode root){
        if(root==null)
        return 0;
        int left_max = findDepth(root.left);
        int right_max = findDepth(root.right);
        diameter = Math.max(left_max+right_max,diameter);
        return Math.max(left_max,right_max)+1;
    }
}
