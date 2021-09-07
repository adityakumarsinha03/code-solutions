// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3965/

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        
        int n = releaseTimes.length;
        
        int time = releaseTimes[0];
        char ans = keysPressed.charAt(0);
        
        for(int i = 1; i<n; i++){
            int temp = releaseTimes[i] - releaseTimes[i-1];
            if(temp > time){
                time = temp;
                ans = keysPressed.charAt(i);
            } else if(temp == time){
                if(Character.compare(ans, keysPressed.charAt(i)) < 0){
                    ans = keysPressed.charAt(i);
                }
            }
            // System.out.println("char= " + ans);
        }
        
        return ans;
    }
}