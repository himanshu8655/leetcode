package leetcode.greedy;

public class MaximumSubArray {
	
	public static void main(String args[]) {
	maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
	}
	
	public static int maxSubArray(int[] nums) {
	       int len=nums.length;
	        int max=nums[0];
	        int sum=0;
	        for (int i=0 ;i<=len-1; i++){
	            sum = sum + nums[i];
	            
	            if(max < sum){
	                max = sum;
	            }

	            if(sum < 0){
	                sum = 0;
	            }

	        }
	        return max;
	    } 
}
