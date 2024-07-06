package leetcode.dp1;

public class HouseRobber {

	public static void main(String[] args) {
		rob(new int[] {2,1,1,2});
	}
	
	public static int rob(int[] nums) {
		int rob1 = 0;
		int rob2 = 0;
		for(int n : nums) {
			int temp = Math.max(n + rob1, rob2);
			rob1 = rob2;
			rob2 = temp;
		}
	return rob1;
	}

}
