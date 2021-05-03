class Solution{
    static List<Integer> minPartition(int n)
    {
        int coins[] = new int[]{1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        
        int ind[] = new int[1000000+1];
        Arrays.fill(ind, 0);
        
        int dp[] = new int[1000000+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for(int i = 0; i<coins.length; i++){
            dp[coins[i]-1] = 1;
        }
        
        for(int i = 0; i<=n; i++){
            if(dp[i] != 1){
                for(int j = 0; j<coins.length; j++){
                    if(i-coins[j] >= 0 && dp[i] > 1+dp[i-coins[j]]){
                        dp[i] = 1+dp[i-coins[j]];
                        ind[i] = i-coins[j];
                    }
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while(ind[n-1] > 0){
            ans.add(n-ind[n-1]-1);
            n = ind[n-1]+1;
        }
        ans.add(n);
        Collections.sort(ans, Collections.reverseOrder());
        return ans;
    }
}