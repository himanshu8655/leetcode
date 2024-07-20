package leetcode.binarysearch;

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] nums = new int[] {-1,0,3,5,9,12};
		int res=search(nums,9);
		System.out.println(res);
	}
	public static int search(int[] nums, int target) {
        int high = nums.length-1;
        int low = 0;

        while(low<=high){
            int mid = (low+high)/2;
            int num = nums[mid];
            if(target == num)
                return mid;
            else if(target<num)
                high = mid;
            else
                low = mid+1;
        }
        return -1;
    }
}
