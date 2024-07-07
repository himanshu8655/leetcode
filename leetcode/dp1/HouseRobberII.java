package leetcode.dp1;

public class HouseRobberII {
	public static void main(String[] args) {
	}
	
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
    return Math.max(dp(nums, 0, n-1),dp(nums, 1, n));
    }
    public int dp(int nums[], int start, int end){
        int nums1 = 0;
        int nums2 = 0;
        for(int i = start; i<end; i++){
            int temp = Math.max(nums1 + nums[i], nums2);
            nums1 = nums2;
            nums2 = temp;
        }
        return nums2;
    }

}
