// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        
        if(n <= 1 || k < 1)
            return 0;
        
		// Maximum number of transaction can be n/2
        if(k > n/2){
            int ans = 0;
            for(int i = 1; i<n; i++)
                ans += Math.max(prices[i]-prices[i-1], 0);
            
            return ans;
        } else{
            int[] buy = new int[k];
            int[] sell = new int[k];
            
            for(int i = 0; i<k; i++){
                buy[i] = Integer.MIN_VALUE;
                sell[i] = 0;
            }
            
            for(int i = 0; i<n; i++){
                for(int j = 0; j<k; j++){
                    if(j == 0){
                        buy[j] = Math.max(buy[j], -prices[i]);
                        sell[j] = Math.max(sell[j], buy[j] + prices[i]);
                    } else{
                        buy[j] = Math.max(buy[j], sell[j-1] - prices[i]);
                        sell[j] = Math.max(sell[j], buy[j] + prices[i]);
                    }
                }
            }
            return sell[k-1];
        }
    }
}