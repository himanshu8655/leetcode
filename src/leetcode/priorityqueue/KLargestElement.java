package leetcode.priorityqueue;

import java.util.PriorityQueue;

public class KLargestElement {
	PriorityQueue<Integer> max_heap;
	int len;

	public KLargestElement(int k, int[] nums) {
        len = k;
        max_heap = new PriorityQueue<>(k);
        for(int num : nums){
            add(num);
        }
    }

	public int add(int num) {
		if (max_heap.size() < len)
			max_heap.add(num);
		else {
			if (max_heap.peek() < num) {
				max_heap.poll();
				max_heap.offer(num);
			}

		}
		return max_heap.peek();
	}
}
