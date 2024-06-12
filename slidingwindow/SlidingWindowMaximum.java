package leetcode.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int[] nums = {-7,-8,7,5,7,1,6,0};
		maxSlidingWindow(nums,4);
	}

    public static int[] maxSlidingWindow(int[] nums, int k) {

		Deque<Integer> dequeue = new ArrayDeque<>();
		int[] res = new int[nums.length - k + 1];
		int res_index = 0;
		for (int i = 0; i < nums.length; i++) {
            if(dequeue.isEmpty()){
                dequeue.add(nums[i]);
            }
			else if (!dequeue.isEmpty() && nums[i] > dequeue.peekLast()) {
				while (!dequeue.isEmpty() && dequeue.peekLast() < nums[i]) {
					dequeue.removeLast();
				}
				dequeue.add(nums[i]);
			}
			else if (!dequeue.isEmpty() && nums[i] <= dequeue.peekLast()) {
				dequeue.addLast(nums[i]);
			}
			if (i >= k - 1) {
				res[res_index] = dequeue.peekFirst();
				if(dequeue.peekFirst()==nums[i-k+1]) {
					dequeue.removeFirst();				
					}
				res_index++;
			}
		}
		return res;    
        }
}
