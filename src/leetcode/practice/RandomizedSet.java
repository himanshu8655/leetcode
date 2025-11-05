package leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

class RandomizedSet {
	public static void main(String args[]) {
		RandomizedSet randomizedSet = new RandomizedSet();
		randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
		randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
		randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
		randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
		randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
		randomizedSet.insert(2); // 2 was already in the set, so return false.
		System.out.println(		randomizedSet.getRandom());
	}
	
    HashMap<Integer, Integer> hmp;
    ArrayList<Integer> lst;
    public RandomizedSet() {
        hmp = new HashMap<Integer, Integer>();
        lst = new ArrayList<Integer>();
    }
    
    public boolean insert(int val) {
        if(hmp.containsKey(val)){
            return false;
        }
        hmp.put(val,lst.size());
        lst.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(hmp.containsKey(val)){
            int idx = hmp.remove(val);
            lst.set(idx, lst.get(lst.size() - 1));
            lst.remove(lst.size() - 1);
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public int getRandom() {
        Random r = new Random();
		int rand = r.nextInt(lst.size());
        return lst.get(rand);
        
    }
}
