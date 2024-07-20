package leetcode.graph;

public class CountComponents {

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 4, 5 }, { 3, 4 }, };
		countComponents(6, edges);
	}

	public static int countComponents(int n, int[][] edges) {
		int parent[] = new int[n];
		int count[] = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			count[i] = 1;
		}
		for (int[] edge : edges) {
			int node1 = edge[0];
			int node2 = edge[1];
			parent[node2] = parent[node1];
			count[count[node1]]++;
		}
		System.out.println(count.toString());
		System.out.println(parent.toString());

		return 0;
	}


}
