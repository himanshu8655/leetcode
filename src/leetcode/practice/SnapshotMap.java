package leetcode.practice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

public class SnapshotMap {
	
	LinkedHashMap<String, Integer> map;
	HashMap<Integer, LinkedHashMap<String, Integer>> snapshots = new HashMap<>();
	int snapshot_id = 0;
	String s = "";
	
	public SnapshotMap() {
		map = new LinkedHashMap<>();
		snapshots = new HashMap<>();
		
	}
	
	public int get(String key, Integer snapId) throws Exception{
		
		if(!snapshots.containsKey(snapId)) {
			throw new NoSuchElementException("snapId not found");
		}
		
		LinkedHashMap<String, Integer> curr_snap = snapshots.get(snapId);
		if(!curr_snap.containsKey(key)) {
			throw new NoSuchElementException("key not found");
		}
		
		return curr_snap.get(key);
	}
	
	public void put(String key, int value) {
		map.put(key, value);
	}
	
	public void delete(String key) {
		map.remove(key);
	}
	
	public int take_snapshot() {
		snapshots.put(snapshot_id, new LinkedHashMap<>(map));
		snapshot_id++;
		return snapshot_id-1;
	}
	
	public static void main(String[] args) {
		
	}

}
