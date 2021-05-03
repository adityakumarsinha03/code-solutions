// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/

class Solution {
    public boolean isPerfectSquare(int num) {

        if (num < 2)
            return true;

        long low = 1;
        long high = 1000000;

        long mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            long x = mid * mid;
            if (x == num)
                return true;
            else if (x > 0 && x < num)
                low = mid + 1;
            else
                high = mid;
        }
        return false;
    }
}