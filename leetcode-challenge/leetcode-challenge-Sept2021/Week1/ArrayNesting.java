// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3960/

class Solution {
    public int arrayNesting(int[] nums) {
        
        int n = nums.length;
        
        int ans = 0;
        int count = 0;
        
        int[] vis = new int[n];
        Arrays.fill(vis, 0);
        
        for(int i = 0; i<n; i++){
            if(vis[i] == 0){
                count = 0;
                int start = nums[i];
                int next;
                int j = start;
                while(true){
                    count++;
                    next = nums[j];
                    
                    if(next == start)
                        break;
                    j = next;
                }
                
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}