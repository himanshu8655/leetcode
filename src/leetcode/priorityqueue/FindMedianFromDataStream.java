package leetcode.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
	  PriorityQueue<Integer> min_heap;
	    PriorityQueue<Integer> max_heap;
	    public FindMedianFromDataStream() {
	        min_heap = new PriorityQueue<>(10);
	        max_heap = new PriorityQueue<>(10,Comparator.reverseOrder());
	    }
	    
	    public void addNum(int num) {
	        if(!min_heap.isEmpty() && min_heap.peek()<=num){
	            min_heap.offer(num);
	        }
	        else{
	            max_heap.offer(num);
	        }
	        int n = max_heap.size();
	        int m = min_heap.size();
	        if(!(Math.abs(n-m)<=1))
	            if(n > m) {
	                int ele = max_heap.poll();
	                min_heap.offer(ele);
	                }
	            else {
	                int ele = min_heap.poll();
	                max_heap.offer(ele);
	            }
	    }
	    
	    public double findMedian() {
	        int N = min_heap.size() + max_heap.size();
	        if(N%2 == 0)
	            return (min_heap.peek() + max_heap.peek()) / 2.0;
	        else
	            return min_heap.size() > max_heap.size() ? min_heap.peek() : max_heap.peek();
	    }
}
