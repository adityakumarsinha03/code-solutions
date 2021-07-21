// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3732/

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 100000);
        
        dp[n-1] = 0;
        for(int i = n-2; i>=0; i--){
            if(nums[i]+i>=n-1)
                dp[i] = 1;
            else{
                for(int j = i; j<=i+nums[i] && j<n-1; j++){
                    if(dp[i]>1+dp[j])
                        dp[i] = 1+dp[j];
                }
            }
        }
        return dp[0];
    }
}