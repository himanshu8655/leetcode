package leetcode.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class DetectSquares {
	class Element{
        int element;
        int freq;

        Element(int element, int freq){
            this.element = element;
            this.freq = freq;
        }
    }
	
	public static void main(String args[]) {
		groupAnagrams(new String[] {"rat", "tar"});
	}
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
    
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Element> hmp = new HashMap<>();
    	PriorityQueue<Element> pq = new PriorityQueue<Element>((o1,o2)-> o2.freq - o1.freq);
        pq.addAll(hmp.values());
        String res = "";
        
        for(int num : nums){
        }
        char c;
        StringBuilder strBuilder;
        String s;
        int[] q;
        ArrayList<Integer> lst = new ArrayList<>();
        Character.isLetterOrDigit(c);
        return new int[] {};
    }
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        int[] freq = new int[26];
        for(String s : strs){
          char[] charArray = s.toCharArray();
          for(char c : charArray){
              freq[c - 'a']++;
          }
          res.computeIfAbsent(Arrays.toString(freq), k->new ArrayList<>()).add(s);
        }
        return new ArrayList<>(res.values());
      }

    public int[] pointToArray(String point){
        int[] res = new int[2];
        String[] points = point.split("%");
        res[0] = Integer.parseInt(points[0]);
        res[1] = Integer.parseInt(points[1]);
        return res;
    }
}

