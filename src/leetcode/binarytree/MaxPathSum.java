package leetcode.binarytree;

public class MaxPathSum {
	public int maxPathSum(TreeNode root) {
        Integer[] res = new Integer[]{Integer.MIN_VALUE};
        maxPathSum(root,res);
        return res[0];
    }

    public int maxPathSum(TreeNode root,Integer[] res){
        if(root == null) return 0;
        int left_sum = maxPathSum(root.left,res);
        int right_sum = maxPathSum(root.right,res);
        left_sum = Math.max(left_sum, 0);
        right_sum = Math.max(right_sum, 0);
        int curr_sum = left_sum + right_sum + root.val;
         res[0] = Math.max(res[0],curr_sum);
        return Math.max(left_sum,right_sum)+root.val;
    }
}
