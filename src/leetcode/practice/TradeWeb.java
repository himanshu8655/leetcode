package leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TradeWeb {
	
	
	
public static void main(String args[]) {
	//list of buy and sell orders
	//def qty is 1
	//eg buy is 7,9,11
	//eg sell 8, 10, 12
	//2 
	
	List<Integer> buy = new ArrayList<>(Arrays.asList(7,11,9));
	List<Integer> sell = new ArrayList<>(Arrays.asList(8,12,10));
	int result = orderTransaction(buy, sell);
	System.out.println(result);
}

public static int orderTransaction(List<Integer> buy, List<Integer> sell) {
	int txnCount = 0;
	int buyPointer = 0;
	int sellPointer = 0;

	buy.sort(null);
	sell.sort(null);
	while(buyPointer<buy.size() && sellPointer<sell.size()) {
		int buyPrice = buy.get(buyPointer);
		int sellPrice = sell.get(sellPointer);
		
		if(buyPrice>=sellPrice) {
			txnCount++;
			buyPointer++;
			sellPointer++;
		}
		else {
			buyPointer++;
		}
	}
	return txnCount;
}
}
