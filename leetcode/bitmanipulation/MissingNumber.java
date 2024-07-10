package leetcode.bitmanipulation;

public class MissingNumber {
	public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(Integer num : nums){
            res = res^num;
        }
        for(int i = 0; i<=n; i++){
            res = res^i;
        }
        return res;
    }
}
