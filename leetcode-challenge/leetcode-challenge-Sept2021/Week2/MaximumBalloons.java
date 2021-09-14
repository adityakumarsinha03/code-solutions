// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3973/

class Solution {
    public int maxNumberOfBalloons(String text) {
        
        int n = text.length();
        int ans = n;
        
        int[] mp = new int[26];
        Arrays.fill(mp, 0);
        
        for(int i = 0; i<n; i++){
            char c = text.charAt(i);
            int x = (int)c - 'a';
            
            mp[x]++;
        }
        
        mp[(int)'l' - 'a'] /= 2;
        mp[(int)'o' - 'a'] /= 2;
        
        String sb = "balloon";
        for(int i = 0; i<sb.length(); i++){
            char c = sb.charAt(i);
            int x = (int)c - 'a';
            ans = Math.min(ans, mp[x]);
        }
        return (ans == n) ? 0 : ans;
    }
}