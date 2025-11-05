package leetcode.practice;

import java.util.HashMap;
import java.util.PriorityQueue;

class StreamAPI {
	public static void main(String args[]) {
		topKFrequent(new int[] {3,0,1,0}, 1);
	}
    static class Element{
        public int freq;
        public int val;
        public Element(int freq, int val){
            this.freq = freq;
            this.val = val;
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Element> minHeap = new PriorityQueue<Element>(
            (a,b)->a.freq-b.freq);
            int[] res = new int[k];
        HashMap<Integer, Element> freq = new HashMap<>();
        for(int num : nums){
            if(freq.containsKey(num)){
                freq.get(num).freq+=1;
            }
            else{
            Element ele = new Element(1, num);
            freq.put(num, ele);
            minHeap.add(ele);
        }
        }
        int i = 0;
        while(k!=0){
            res[i] = minHeap.poll().val;
            i++;
            k--;

        }
        return res;  
    }
}