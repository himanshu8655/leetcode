package leetcode.binarytree;

import java.util.ArrayList;

public class kthSmallestElement {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        inOrderTraversal(root,lst);
        return lst.get(k-1);
    }
    public void inOrderTraversal(TreeNode root, ArrayList<Integer> lst){
        if(root == null)
        return;
        inOrderTraversal(root.left,lst);
        lst.add(root.val);
        inOrderTraversal(root.right,lst);
    }
}
