/*

Given a binary grid i.e. a 2D grid only consisting of 0’s and 1’s, find the area of the largest rectangle inside 
the grid such that all the cells inside the chosen rectangle should have 1 in them. You are allowed to permutate 
the columns matrix i.e. you can arrange each of the column in any order in the final grid. 
Please follow the below example for more clarity.

Lets say we are given a binary grid of 3 * 3 size.
1 0 1
0 1 0
1 0 0 
At present we can see that max rectangle satisfying the criteria mentioned in the problem is of 1 * 1 = 1 area 
i.e either of the 4 cells which contain 1 in it. Now since we are allowed to permutate the columns of the 
given matrix, we can take column 1 and column 3 and make them neighbours. One of the possible configuration of the grid can be:
1 1 0
0 0 1
1 0 0 
Now In this grid, first column is column 1, second column is column 3 and third column is column 2 from the 
original given grid. Now, we can see that if we calculate the max area rectangle, we get max area as 1 * 2 = 2 
which is bigger than the earlier case. Hence 2 will be the answer in this case.

*/

Solution:

int Solution::solve(vector<vector<int> > &a){
    
    int m = a.size();
    int n = a[0].size();
    int d[m][n];
    
    // Create a matrix which contains maximum number of 1's in the column at each cell
    for(int j = 0; j<n; j++){
        for(int k = 0; k<m; k++){
            if(k==0 && a[k][j]==1){
                d[k][j]=1;
            }
            else if(a[k][j]==0){
                d[k][j]=0;
            }
            else{
                d[k][j]=(d[k-1][j]+1);
            }
        }
    }
    vector<vector<int> >dp(m, vector<int>(n));
    for(int k=0; k<m; k++){
        for(int j = 0; j<n; j++){
           dp[k][j] = d[k][j];
        }
    }
    
    // Sort all the rows
    for(int k = 0; k<m; k++){
        sort(dp[k].begin(), dp[k].end(), greater<int>());
    }
    
    // Multiply all the cell by the (column+1) and check for the maximum value.
    // That value will be the maximum area
    int ans = INT_MIN;
    for(int k = 0; k<m; k++){
        for(int j = 0; j<n; j++){
            int x = (j+1)*dp[k][j];
            ans = max(x, ans);
        }
    }
    return ans;
}
