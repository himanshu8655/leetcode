package leetcode.priorityqueue;

import java.util.PriorityQueue;

public class KClosestPoint {
	 public class Distance{
	        int dist;
	        int idx;
	        public Distance(int dist, int idx){
	            this.dist = dist;
	            this.idx = idx;
	        }
	        public int getDist() {
	        	return dist;
	        }
	            public int getIndex() {
	        	return idx;
	        }
	    }
	    public int[][] kClosest(int[][] points, int k) {
	        PriorityQueue<Distance> max_heap = new PriorityQueue<>(k,((a,b)->Integer.compare(b.getDist(),a.getDist())));
	        int[][] res = new int[k][2];
	        for(int i = 0;i<points.length;i++)
	        {
	            int x = points[i][0];
	            int y = points[i][1];
	            int distance = (int)(Math.pow(x,2)+Math.pow(y,2));
	            Distance dist_obj = new Distance(distance,i);
	            if(max_heap.size()<k)
	                max_heap.offer(dist_obj);
	            else{
	                if(max_heap.peek().getDist()>distance){
	                    max_heap.poll();
	                    max_heap.offer(dist_obj);
	                }
	            }
	        }
	        int i = -1;
	        while(!max_heap.isEmpty()){
	            i++;
	            res[i] = points[max_heap.poll().getIndex()];
	        }
	        return res;
	    }
}
