package leetcode.practice;

import java.util.HashMap;
import java.util.HashSet;

class DetectSquares {
    HashMap<String, HashSet<String>> points;
    public DetectSquares() {
        points = new HashMap<>();
    }
    
    public void add(int[] point) {
        points.computeIfAbsent("*" + point[1], k-> new HashSet<>()).add(pointToString(point));
        points.computeIfAbsent(point[0] + "*", k-> new HashSet<>()).add(pointToString(point));
        points.computeIfAbsent(pointToString(point), k-> new HashSet<>()).add(pointToString(point));
    }
    
    public int count(int[] point) {
        int res = 0;
        HashSet<String> lst1 = points.getOrDefault("*"+point[1], new HashSet<String>());
        HashSet<String> lst2 = points.getOrDefault(point[0]+"*", new HashSet<String>());
        
        for(String str : lst1){
        	int[] newPoint = pointToArray(str);
        	int distance = Math.abs(point[0] - newPoint[0]);
        	if(points.containsKey(point[0]+"%" + (point[1]-distance) ) && points.containsKey(newPoint[0]+"%" + (newPoint[1]-distance) )) {
        		res++;
        	}
        	else if(points.containsKey(point[0]+"%" + (point[1]+distance) ) && points.containsKey(newPoint[0]+"%" + (newPoint[1]+distance) )) {
        		res++;
        	}

        	
        }
        
        for(String str : lst2) {
        	int[] newPoint = pointToArray(str);
        	int distance = Math.abs(point[1] - newPoint[1]);
        	if(points.containsKey((point[0]+distance)+"%" + point[1] ) && points.containsKey((newPoint[0]+distance)+"%" + newPoint[1])) {
        		res++;
        	}
        	else if(points.containsKey((point[0]-distance)+"%" + point[1] ) && points.containsKey((newPoint[0]-distance)+"%" + newPoint[1])) {
        		res++;
        	}
        }
        return res;
        
    }

    public String pointToString(int[] point){
        return point[0]+"%"+point[1];
    }

    public int[] pointToArray(String point){
        int[] res = new int[2];
        String[] points = point.split("%");
        res[0] = Integer.parseInt(points[0]);
        res[1] = Integer.parseInt(points[1]);
        return res;
    }
}



/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */