// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

class Solution {
	public int maxProfit(int[] prices) {
        int n = prices.length;
        
        if(n <= 0)
            return 0;
        
        int buy1 = Integer.MAX_VALUE; // want to minimize buy price
        int profit1 = 0; // want to maximize profit
        int buy2 = Integer.MAX_VALUE;
        int profit2 = 0;
        
        for(int i = 0; i<n; i++){
            buy1 = Math.min(buy1, prices[i]);
            profit1 = Math.max(profit1, prices[i]-buy1);
            buy2 = Math.min(buy2, prices[i]-profit1);
            profit2 = Math.max(profit2, prices[i]-buy2);
        }
        return profit2;
    }
	
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        if(n <= 0)
            return 0;
        
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;
        
        for(int i = 0; i<n; i++){
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}