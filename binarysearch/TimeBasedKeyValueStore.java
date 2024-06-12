package leetcode.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */


public class TimeBasedKeyValueStore {
	 HashMap<String,ArrayList<Data>> storage = new HashMap<>();
     String value;
     int timestamp;

    public class Data{
        String value;
        int timestamp;

        public Data(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
        }
        
        public String getValue(){
            return value;
        }
        
        public int getTimestamp(){
            return timestamp;
        }
    }

    public TimeBasedKeyValueStore() {
        
    }

    public void set(String key, String value, int timestamp) {
        Data data = new Data(value,timestamp); 
        ArrayList<Data> lst=storage.getOrDefault(key,new ArrayList<Data>());  
        lst.add(data);
        storage.put(key,lst);
    }
    
    public String get(String key, int timestamp) {
       List<Data> lst = storage.get(key);
       if(lst == null) return "";
       String res = binarySearch(lst,timestamp);
       return res;
    }

    public static String binarySearch(List<Data> lst, int target){
        int l = 0;
        int n = lst.size();
        int r = n-1;
        int m = 0;
        String res = "";
        while(l<=r){
             m = (l + r)/2;
            Data data = lst.get(m);
            if(target == data.getTimestamp())   
            {
                return data.getValue();
            }

            if(target<=data.getTimestamp()){
                r = m-1;

            }
            else{
                res = lst.get(m).getValue();
                l = m + 1;

            }
        }
        if(target<lst.get(0).getTimestamp())
            return "";

        return res;
    }
}
