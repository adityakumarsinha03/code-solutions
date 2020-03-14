/*

Given a 2 * N Grid of numbers, choose numbers such that the sum of the numbers
is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Example:

Grid:
	1 2 3 4
	2 3 4 5
so we will choose
3 and 5 so sum will be 3 + 5 = 8


Note that you can choose more than 2 numbers

*/

Solution:

int Solution::adjacent(vector<vector<int> > &a){
    
    int n = a[0].size();
    vector<int>b(n);
    for(int i = 0; i<n; i++){
        b[i] = max(a[0][i], a[1][i]);
    }
    if(n == 2){
        return max(b[0], b[1]);
    }
    int dp[n];
    dp[0] = b[0];
    dp[1] = b[1];
    dp[2] = max(dp[0]+b[2], dp[1]);
    
    for(int i = 3; i<n; i++){
        dp[i] = max(dp[i-3]+b[i], max(dp[i-2]+b[i], dp[i-1]));
    }
    return dp[n-1];
    /*
    int dp[n][2];
    int e, curr;
    e = max(a[0][0], a[1][0]);
    dp[0][0] = 0;
    dp[0][1] = e;
    for(int i = 1; i<n; i++){
        curr = max(a[0][i], a[1][i]);
        dp[i][0] = max(dp[i-1][0], dp[i-1][1]);
        dp[i][1] = curr+dp[i-1][0];
    }
    return max(dp[n-1][0], dp[n-1][1]);*/  
}
