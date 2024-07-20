package leetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ValidTree {
	
	public static void main(String args[]) {
		 int[][] edges = {
		            {1, 4},
		            {0, 1},
		            {0, 2},
		            {0, 3},
		        };
		validTree(5,edges);
	}
	
	public static boolean validTree(int n, int[][] edges) {
		if (n-1 != edges.length)
			return false;

		List<Integer>[] tree = new ArrayList[n];
		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Integer> set = new HashSet<>(n);

		for (int i = 0; i < n; i++) {
			tree[i] = new ArrayList<Integer>();
		}

		for (int[] edge : edges) {
			tree[edge[0]].add(edge[1]);
			tree[edge[1]].add(edge[0]);
		}
		queue.add(0);
		set.add(0);
		while (!queue.isEmpty()) {
			int curr_node = queue.poll();
			int sz = tree[curr_node].size();
			for(int i = 0;i<sz;i++) {
				int val = tree[curr_node].get(i);
				if(!set.contains(val)) {
					set.add(val);
					queue.add(val);
				}
			}
		}
		return set.size() == n;
	}
}
