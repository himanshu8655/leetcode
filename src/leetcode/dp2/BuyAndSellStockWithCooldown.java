package leetcode.dp2;

import java.util.HashMap;

public class BuyAndSellStockWithCooldown {
    HashMap<String,Integer> dp = new HashMap<>();
    
    public int maxProfit(int[] prices) {
        return dfs(0,prices, true);
    }
    public int dfs(int i, int[] price,boolean can_buy){
        if(i>=price.length)
            return 0;
        StringBuilder keyBuilder = new StringBuilder();
        keyBuilder.append(i).append("-").append(can_buy);
        String key = keyBuilder.toString();
            if(dp.containsKey(key)){
                return dp.get(key);
            }
        if(can_buy) {
            int cooldown = dfs(i+1,price,true);
            int buy = dfs(i+1,price,false) - price[i];
            dp.put(key, Math.max(buy, cooldown));
            return dp.get(key);
        }
        else{
            int sell = dfs(i+2,price,true) + price[i];
            int cooldown = dfs(i+1,price,false);
            dp.put(key, Math.max(sell, cooldown));
            return dp.get(key);
        }
    }
}
