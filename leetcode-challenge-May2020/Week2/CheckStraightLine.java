// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {

        int x, y;
        int xlast = coordinates[0][0];
        int ylast = coordinates[0][1];

        int xorig = coordinates[1][0] - xlast;
        int yorig = coordinates[1][1] - ylast;

        int xdiff, ydiff;
        for (int i = 2; i < coordinates.length; i++) {
            x = coordinates[i][0];
            y = coordinates[i][1];

            xdiff = x - xlast;
            ydiff = y - ylast;
            if (yorig == 0 && ydiff != 0)
                return false;
            if (xorig == 0 && xdiff != 0)
                return false;
            if (ydiff * xorig != xdiff * yorig)
                return false;
        }
        return true;
    }
}