package com.codesignal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//centerCapacities: [1, 2, 1, 2, 1] 
//dailyLog: ["PACKAGE", "PACKAGE", "CLOSURE 2", "PACKAGE", "CLOSURE 3", "PACKAGE", "PACKAGE"]
public class Drone {

	public static void main(String[] args) {
		int i = solution(new int[] {1, 2, 1, 2, 1}, new String[] {"PACKAGE", "PACKAGE", "CLOSURE 2", "PACKAGE", "CLOSURE 3", "PACKAGE", "PACKAGE"});
System.out.println(i);
	}
	
	static int solution(int[] centerCapacities, String[] dailyLog) {
	    int n = centerCapacities.length;
	    Set<Integer> closedCenter = new HashSet<>();
	    int[] currentCapacity = new int[n];
	    for(int i = 0; i<currentCapacity.length; i++){
            currentCapacity[i] = centerCapacities[i];
        }
	    int[] result = new int[n];
	    int idx = 0;
	    for(String log : dailyLog){
	        //package
	        if(log.equals("PACKAGE")){
	            //if closed
	            if(closedCenter.contains(idx)){
	                idx = incrementCapacity(idx, currentCapacity, centerCapacities);
	            }
	            //if open
	            else{
	                while(currentCapacity[idx]<=0){
	                    idx = incrementCapacity(idx, currentCapacity, centerCapacities);
	                }
	                currentCapacity[idx]--;
	                result[idx]++;
	                
	            }
	            
	            System.out.println(Arrays.toString(result));
	        }
	        // closure
	        else{
	            closedCenter.add(Integer.parseInt(log.split(" ")[1]));
	            idx = incrementCapacity(idx, currentCapacity, centerCapacities);

	        }
	    }
	    int temp_max = 0;
	    int temp_idx = 0;
	    for(int i = 0; i<result.length; i++){
	        if(temp_max<=result[i]){
	            temp_max = result[i];
	            temp_idx = i;
	        }
	    }
	    return temp_idx;
	}

	static int incrementCapacity(int idx, int[] currentCapacity, int[] centerCapacities){
	    if(idx == currentCapacity.length - 1){
	        idx = 0;
	        for(int i = 0; i<currentCapacity.length; i++){
	            currentCapacity[i] = centerCapacities[i];
	        }
	    }
	    else idx++;
	    
	    return idx;
	}


}
