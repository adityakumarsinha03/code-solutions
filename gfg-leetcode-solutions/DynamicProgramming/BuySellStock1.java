// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
	public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int maxProfit = 0;
        int temp[] = new int[n];
        temp[n-1] = prices[n-1];
        for(int i = n-2; i>=0; i--){
            temp[i] = Math.max(temp[i+1], prices[i]);
        }
        
        for(int i = 0; i<n; i++){
            maxProfit = Math.max(maxProfit, temp[i]-prices[i]);
        }
        return maxProfit;
    }
	
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        if(n <= 0)
            return 0;
        
        int[] sm = new int[n];
        int[] lg = new int[n];
        
        sm[0] = 0;
        for(int i = 1; i<n; i++){
            if(prices[i] < prices[sm[i-1]])
                sm[i] = i;
            else
                sm[i] = sm[i-1];
        }
        
        lg[n-1] = n-1;
        for(int i = n-2; i>=0; i--){
            if(prices[i] > prices[lg[i+1]])
                lg[i] = i;
            else
                lg[i] = lg[i+1];
        }
        
        int ans = 0;
        for(int i = 0; i<n; i++){
            if(sm[i] < lg[i])
                ans = Math.max(ans, prices[lg[i]]-prices[sm[i]]);
        }
        return ans;
    }
}