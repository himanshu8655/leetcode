package leetcode.binarytree;

public class ConstructBT {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getBinaryTree(preorder,inorder, 0, 0, inorder.length-1);
    }
    public TreeNode getBinaryTree(int[] preorder, int[] inorder, int root_i, int start, int end){
        if(start > end || root_i>preorder.length-1) return null;
        int root_val = preorder[root_i];
        TreeNode root = new TreeNode(root_val);
        int root_idx_inorder = 0;
        for(int i = start; i<=end; i++){
            if(inorder[i] == root_val){
                root_idx_inorder = i;
                break;
            }
        }
        root.left = getBinaryTree(preorder, inorder, root_i + 1, start, root_idx_inorder-1);
        root.right = getBinaryTree(preorder, inorder,root_idx_inorder-start+root_i+1, root_idx_inorder+1, end);
        return root;
    }
}
