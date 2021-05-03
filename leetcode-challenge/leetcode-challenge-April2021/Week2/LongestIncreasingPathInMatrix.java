// https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3703/

class Solution {
    public int lipUtil(int[][] matrix, int[][] dp, int m, int n, int x, int y){
        // if(dp[x][y] != -1)
            // return dp[x][y];
        if(dp[x][y] < 0) {
            
            int result = 0;
            if(x == m-1 && y == n-1)
                dp[x][y] = 1;
            
            if(x == 0 || y == 0)
                result = 1;
            
            if(x == m-1 || y == n-1)
                result = 1;
            
            if(x+1 < m && matrix[x+1][y] > matrix[x][y])
                result = 1 + lipUtil(matrix, dp, m, n, x+1, y);
            
            if(y+1 < n && matrix[x][y+1] > matrix[x][y])
                result = Math.max(result, 1 + lipUtil(matrix, dp, m, n, x, y+1));
            
            if(y-1 >= 0 && matrix[x][y-1] > matrix[x][y])
                result = Math.max(result, 1 + lipUtil(matrix, dp, m, n, x, y-1));
            
            if(x-1 >= 0 && matrix[x-1][y] > matrix[x][y])
                result = Math.max(result, 1 + lipUtil(matrix, dp, m, n, x-1, y));
            
            dp[x][y]= (result==0)?1:result;
        }
        return dp[x][y];        
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int dp[][] = new int[m+1][n+1];
        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], -1);
        
        int ans = -1;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                ans = Math.max(ans, lipUtil(matrix, dp, m, n, i, j));
            }
        }
        return ans;
    }
}