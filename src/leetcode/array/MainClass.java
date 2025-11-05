package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MainClass {
public static void main(String args[]) {
	
	//retrieve O(n) sequential storing 0f data
	ArrayList<Integer> list = new ArrayList<>();
	list.add(0);
	list.add(1);
	list.add(2);
	for(int i = 0; i<list.size(); i++) {
		if(1 == list.get(i)) {
			//true 
		}
	}
	
	// O(1) retrieve and insert python dictionary
	HashMap<String, Integer> hmp = new HashMap<>();
	hmp.put("key1", 1);
	hmp.put("key2", 1);
	hmp.put("key3", 1);
	hmp.put("key4", 1);
	hmp.containsKey("key2");
	hmp.get("key1");
	
	//for sorted data minheap, maxheap
	PriorityQueue<Integer> queue = new PriorityQueue<>();
	queue.add(3);
	queue.offer(5);
	queue.add(1);
	while(!queue.isEmpty()) {
		System.out.print(queue.poll());
		System.out.println("===");
	}
}

}
