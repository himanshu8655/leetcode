package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class ProductExceptSelf {
	  public int[] productExceptSelf(int[] nums) {
	        Set<String> set = new HashSet<>();
	        int product = 1;
	        boolean contains_zero = false;
	        for (Integer i : nums) {
	            if (i == 0) {
	                if (contains_zero == true) {
	                    product = 0;
	                    break;
	                }
	                contains_zero = true;
	            } else
	                product *= i;

	        }
	        for (int i = 0; i < nums.length; i++) {
	            if (!contains_zero)
	                nums[i] = product / nums[i];
	            else if (contains_zero) {
	                if (nums[i] == 0)
	                    nums[i] = product;
	                else
	                    nums[i] = 0;

	            }
	        }
	        return nums;
	    }
}
