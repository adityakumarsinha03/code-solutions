// https://practice.geeksforgeeks.org/problems/coin-change2448/1

class Solution
{
    public long count(int S[], int m, int n) 
    {
        long dp[][] = new long[m+1][n+1];
        for(int i = 0; i<=m; i++){
            for(int j = 0; j<=n; j++){
                dp[i][j] = 0;
            }
        }
        for(int i = 0; i<=m; i++){
            dp[i][0] = 1;
        }
        
        for(int i = 0; i<=n; i++){
            dp[0][i] = 0;
        }
       
		// (skip the coin) + (take the coin)
		// func(n, m-1) + func(n-S[m], m)
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(j-S[i-1] >= 0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-S[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[m][n];
    } 
}