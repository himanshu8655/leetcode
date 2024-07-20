package leetcode.dp1;

public class MaximunProductSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int optimizedKadanesAlgo(int[] nums) {
		int product = 1;
		int n = nums.length;
		int max_product = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (product * nums[i] <= Integer.MAX_VALUE || product * nums[i] >= Integer.MIN_VALUE)
				product *= nums[i];
			max_product = Math.max(product, max_product);

			if (nums[i] == 0)
				product = 1;
		}
		product = 1;
		for (int i = n - 1; i >= 0; i--) {
			if (product * nums[i] <= Integer.MAX_VALUE || product * nums[i] >= Integer.MIN_VALUE)

				product *= nums[i];
			max_product = Math.max(product, max_product);

			if (nums[i] == 0)
				product = 1;
		}
		return max_product;
	}

	public int maxProduct(int[] nums) {
		int max1 = findMaxProduct(nums);
		reverseArray(nums);
		int max2 = findMaxProduct(nums);
		return Math.max(max1, max2);
	}

	public void reverseArray(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			// Swap the elements
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			// Move the pointers
			start++;
			end--;
		}
	}

	public int findMaxProduct(int[] nums) {
		int prev_product = 1;
		int curr_product = 1;
		boolean isNegative = false;
		int last_negative_no = 1;
		int max_product = Integer.MIN_VALUE;
		for (int num : nums) {
			if (num == 0) {
				curr_product = 1;
				prev_product = 1;
				isNegative = false;
			} else if (num > 0) {
				curr_product *= num;
				max_product = Math.max(max_product, curr_product);
			} else {

				if (isNegative) {
					curr_product *= prev_product * (num) * last_negative_no;
					prev_product = 1;
					max_product = Math.max(max_product, curr_product);
				} else {
					prev_product = curr_product;
					curr_product = 1;
					last_negative_no = num;
				}
				isNegative = !isNegative;
			}
			max_product = Math.max(max_product, num);

		}
		return max_product;
	}

}
