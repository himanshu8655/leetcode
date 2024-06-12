package leetcode.binarytree;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }
        if(subRoot == null) return true;
        if(root == null) return false;
        return checkIfSame(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);

    }
    public boolean checkIfSame(TreeNode root1, TreeNode root2){
        if(root1==null && root2 == null)
        return true;
        if(root1 == null || root2 == null)
        return false;
        if(root1.val == root2.val){
            boolean left = checkIfSame(root1.left,root2.left);
            boolean right = checkIfSame(root1.right,root2.right);
            return left && right;
        }
        return false;
    }
}
