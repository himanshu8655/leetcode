package leetcode.binarytree;

public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if(root==null)
        return null;
        
            TreeNode left = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(left);
        
        return root;
    }
}
