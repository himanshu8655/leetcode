package leetcode.practice;

import java.util.PriorityQueue;

public class MediaFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MediaFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>((a,b)-> b-a);
    }
	public static void main(String args[]) {
		MediaFinder f = new MediaFinder();
		f.addNum(3);
		f.addNum(2);
		f.addNum(1);
		System.out.println(f.findMedian());

	}
    public void addNum(int num) {
        minHeap.add(num);
        if(!maxHeap.isEmpty() && maxHeap.peek()<minHeap.peek()){
        	int no = minHeap.poll();
            maxHeap.offer(no);
        }
        else{
            if (minHeap.size()-maxHeap.size()>1){
                 int no = minHeap.poll();
                maxHeap.offer(no);
            }
            if (maxHeap.size()-minHeap.size()>1){
                 int no = maxHeap.poll();
                minHeap.offer(no);
            }
        }
    }
    
    public double findMedian() {
        if(minHeap.size()>maxHeap.size()){
            return minHeap.peek();
        }
        else if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }
        else {
        double num1 = Double.parseDouble(minHeap.peek().toString());
        double num2 = Double.parseDouble(maxHeap.peek().toString());
        return (num1+num2)/2.0;
        }
    }
}
