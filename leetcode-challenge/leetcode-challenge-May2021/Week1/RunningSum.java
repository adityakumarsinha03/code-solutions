// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3730/

class Solution {
    public int[] runningSum(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i<nums.length; i++){
            dp[i] = dp[i-1] + nums[i];
        }
        return dp;
    }
}