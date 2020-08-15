// https://leetcode.com/problems/greatest-sum-divisible-by-three/

class Solution {
    public int sumUtil(int[] nums, int n, int sum, int[][] dp){
        if(n == 0 && sum%3 != 0)
            return 0;
        
        if(n == 0 && sum%3 == 0)
            return sum;
        
        if(dp[n][sum] != -1)
            return dp[n][sum];
        
        return dp[n][sum] = Math.max(sumUtil(nums, n-1, sum+nums[n-1], dp), sumUtil(nums, n-1, sum, dp));
    }
    public int maxSumDivThree(int[] nums) {
        
        int n = nums.length;
        int sumA = 0;
        for(int i = 0; i<n; i++){
            sumA += nums[i];
        }
        int[][] dp = new int[n+1][sumA+1];
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=sumA; j++){
                dp[i][j] = -1;
            }
        }
        
        int sum = 0;
        int ans = sumUtil(nums, n, sum, dp);
        return ans; 
    }
}