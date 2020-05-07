/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/
 */

class Solution {
    public int numJewelsInStones(String J, String S) {

        int a[] = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = 0;
        }
        for (int i = 0; i < J.length(); i++) {
            int x = (int) J.charAt(i) - 60;
            a[x] = 1;
        }
        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            int x = (int) S.charAt(i) - 60;
            if (a[x] > 0)
                ans++;
        }
        return ans;
    }
}