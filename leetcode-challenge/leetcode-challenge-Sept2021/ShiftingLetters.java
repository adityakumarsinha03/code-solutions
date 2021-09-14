// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3968/

class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        
        int n = shifts.length;
        if(n>=1){
            shifts[n-1] = shifts[n-1]%26;
        }
        for(int i = n-2; i>=0; i--){
            shifts[i] = (shifts[i]%26 + shifts[i+1]%26)%26;
        }
        
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i<n; i++){
            int x = (int)(s.charAt(i));
            char c;
            if(x+shifts[i] <= 97+25){
                c = (char)(x+shifts[i]);
                // ans += Character.toString(c);
            } else{
                c = (char)(x+shifts[i]-26);
                // ans += Character.toString(c);
            }
            ans.append(Character.toString(c));
        }
        return ans.toString();
    }
}