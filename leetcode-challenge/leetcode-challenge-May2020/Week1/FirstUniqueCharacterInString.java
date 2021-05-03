/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3320/
 */
class Solution {
    public int firstUniqChar(String s) {
        
        int a[] = new int[26];
        for(int i = 0; i<26; i++){
            a[i] = 0;
        }
        for(int i = 0; i<s.length(); i++){
            int x = (int)s.charAt(i) - 'a';
            a[x]++;
        }
        
        for(int i = 0; i<s.length(); i++){
            int x = (int)s.charAt(i) - 'a';
            if(a[x]==1){
                return i;
            }
        }
        return -1;
    }
}