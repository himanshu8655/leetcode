package com.codesignal;

public class PhoneBatteryRecharge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solution(int t, int[] capacity, int[] recharge) {
		int batteryUsed = 0;
		int timestamp = 0;
		boolean flag = false;
		int[] lastRecharge = new int[capacity.length];
		for(int i = 0; i<capacity.length; i++) {
			if(timestamp>=lastRecharge[i]) {
				lastRecharge[i] = recharge[i]+timestamp;
				timestamp+=capacity[i];
				batteryUsed++;
				if(timestamp > t) {
					return batteryUsed -1;
				}
				else if(timestamp == t){
				return batteryUsed;
				}
			}
			if(i == capacity.length -1 && !flag) {
				return -1;
			}
			else if(i == capacity.length - 1) {
				i = 0;
			}
			
		}
		return -1;
	}
}
