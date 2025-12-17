package leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
	//3
// 9   20
	//15	7
//[3,9,20,null,null,15,7]
	public static void main(String[] args) {
		TreeNode root =
			    new TreeNode(3,
			        new TreeNode(9),
			        new TreeNode(20,
			            new TreeNode(15),
			            new TreeNode(7)
			        )
			    );
		maxDepth(root);

	}
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int left,right = 0;
        left = 1 + maxDepth(root.left);
        right = 1 + maxDepth(root.right);
        return Math.max(left,right);
    }
}
