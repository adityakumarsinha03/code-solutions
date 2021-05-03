// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/

class Solution {
    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;

        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}