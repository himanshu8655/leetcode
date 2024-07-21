package leetcode.slidingwindow;

public class BuyAndSellStock {
    public int maxProfit(int[] stock) {
	int buy = 0;
		int sell = 1;
		int n = stock.length;
		int max_profit = 0;
		while (sell < n) {
			if(stock[buy] < stock[sell]){
			int diff = stock[sell] - stock[buy];
			max_profit = Math.max(max_profit, diff);
			sell++;
			}
			else {
				buy = sell;
				sell++;
			}
		}
		return max_profit;
    }

}
