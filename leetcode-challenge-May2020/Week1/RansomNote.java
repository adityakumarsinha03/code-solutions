// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int a[] = new int[100];
        for(int i = 0; i<100; i++){
            a[i] = 0;
        }
        for(int i = 0; i<magazine.length(); i++){
            int x = (int)magazine.charAt(i) - 60;
            a[x]++;
        }
        for(int i = 0; i<ransomNote.length(); i++){
            int x = (int)ransomNote.charAt(i) - 60;
            if(a[x]>0)
                a[x]--;
            else
                return false;
        }
        return true;
    }
}