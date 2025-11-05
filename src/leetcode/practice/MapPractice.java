package leetcode.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

public class MapPractice {

	public static void main(String[] args) {
		TreeMap<Integer,Integer> treeMap = new TreeMap<>();
		treeMap.put(2,2);
		treeMap.put(3, 3);
//		tmp.put(4, 4);
//		tmp.put(5, 5);
		treeMap.put(6, 6);
		treeMap.put(7, 7);
		for(Integer key:treeMap.descendingKeySet()) {
			//System.out.println(key);
		}
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(10,(o1,o2)-> o2-o1);
		LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
		Stack<Integer> stack = new Stack<>();
		LinkedList<Integer> linkedList = new LinkedList<>();
		Deque<Integer> deque = new ArrayDeque<>();
		ArrayList<Integer> arrayList = new ArrayList<>();
		ArrayList<Integer> arrayList2 = new ArrayList<>();
		arrayList2.addAll(arrayList);
		StringBuilder stringBuilder = new StringBuilder("Himanshu");
		System.out.print(stringBuilder);
		Collections.sort(arrayList,(a,b)->b-a);
		priorityQueue.add(6);
		priorityQueue.add(3);
		System.out.print(priorityQueue);
		Map.Entry<Integer, Integer> map =  linkedHashMap.firstEntry();
	}

}
