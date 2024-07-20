package leetcode.graph;

public class RedundantConnection {
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for(int[] edge : edges){
            if(!union(edge[0], edge[1]))
                return edge;
        }
        return new int[0];
    }

    public int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y){
        int node1 = find(x);
        int node2 = find(y);
        if(node1 == node2)
            return false;
        else if(rank[node1]>rank[node2]){
            parent[node1] = node2;
        }
        else{
            parent[node2] = node1;
            rank[node1] ++;
        }
        return true;
    }
}
