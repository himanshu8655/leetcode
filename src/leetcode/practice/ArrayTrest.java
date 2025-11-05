package leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class ArrayTrest {

	public static void main(String[] args) {
		ArrayList<Integer> res = new ArrayList<>(Arrays.asList(1,2,3,4));
		res.add(5);
		res.add(3);
		int[] arr = new int[] {1,3,3};
		int a =  Arrays.stream(arr).distinct().boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
		System.out.println(a);
	}


int[] solution(long[] timestamps, String[] ipAddresses, int limit, int timeWindow) {
    HashMap<String, List<Long>> hmp = new HashMap<String, List<Long>>();
    int n = ipAddresses.length;
    HashMap<String, Queue<Long>> rateLimiter = new HashMap<>();
    Deque<Long> queue = new LinkedList<>();
    HashMap<String, String> hmp11 = new HashMap<>();
    int[] res = new int[n];
    for(int i = 0; i<n; i++){
         hmp.computeIfAbsent(ipAddresses[i], k->new ArrayList<Long>()).add(timestamps[i]);
    }	
    
    for(Map.Entry<String, List<Long>> value : hmp.entrySet()){
    Queue<Long> queu = new LinkedList<Long>();
    for(Long val : value.getValue()){
		queue.add(val);
    	while(queue.size()>limit) {
    		long start_timestamp = queue.peek();
    		int diff = (int) (val - start_timestamp);
    		if(diff>timeWindow) {
    			queue.poll();
    		}
    	}
    }
    }
    
    return res;
}


}
