package leetcode.twopointer;

public class ContainerWithMaxWater {
    public int maxArea(int[] height) {
        int left=0;
		int n = height.length;
		int right = n-1;
		int max_water=0;
		while(left<right) {
			int new_water_sz= Math.min(height[left], height[right])*(right-left);
			max_water=Math.max(max_water, new_water_sz);
			if(height[left]>height[right]) {
				right--;
			}
			 else if(height[left]<height[right]) {
				left++;
			}
			else{
				left++;
				right--;
			}
		}
		return max_water;
    }
}
