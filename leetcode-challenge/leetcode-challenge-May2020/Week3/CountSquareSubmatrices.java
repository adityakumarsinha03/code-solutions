// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3336/

class Solution {
    public int countSquares(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println(m + " " + n);
        int dp[][] = matrix;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1)
                    dp[i][j] = Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i][j - 1])) + 1;
                else
                    dp[i][j] = 0;
            }
        }

        int count[] = new int[1000];
        for (int i = 0; i < 1000; i++)
            count[i] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count[dp[i][j]]++;
            }
        }

        for (int i = 998; i > 0; i--) {
            count[i] += count[i + 1];
        }

        int ans = 0;
        for (int i = 1; i < 1000; i++)
            ans += count[i];

        return ans;
    }
}