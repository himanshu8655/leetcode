package leetcode.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> max_heap = new PriorityQueue<Integer>(stones.length,Comparator.reverseOrder());
    for(int stone : stones){
        max_heap.add(stone);
    }
    while(max_heap.size()>1){
        int x = max_heap.poll();
        int y = max_heap.poll();
        if(x == y) continue;
        max_heap.offer(x-y);

    }
    return max_heap.isEmpty()?0:max_heap.peek();

    }
}
