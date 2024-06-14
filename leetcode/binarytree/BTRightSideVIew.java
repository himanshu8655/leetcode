package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BTRightSideVIew {
    List<Integer> res = new ArrayList<Integer>();
    
    public List<Integer> rightSideView(TreeNode root) {
        traverseTree(root,0);
        return res;
    }
    public TreeNode traverseTree(TreeNode root,int level){
        if(root == null)
        return null;
        if(res.size()==level) res.add(0);
        res.set(level,root.val);
        traverseTree(root.left,level+1);
        traverseTree(root.right,level+1);
        return root;
    }
}
