/*

A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).

Path Sum: Example 1

The robot can only move either down or right at any point in time. The robot is trying to reach the 
bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

How many possible unique paths are there?

Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.

Example :

Input : A = 2, B = 2
Output : 2

2 possible routes : (0, 0) -> (0, 1) -> (1, 1) 
              OR  : (0, 0) -> (1, 0) -> (1, 1)

*/

Solution:

int Solution::uniquePaths(int a, int b){
    
    int t[a][b];
    for(int i = 0; i<b; i++){
        t[0][i] = 1;
    }
    for(int i = 0; i<a; i++){
        t[i][0] = 1;
    }
    for(int i = 1; i<a; i++){
        for(int j = 1; j<b; j++){
            t[i][j] = t[i-1][j] + t[i][j-1];
        }
    }
    return t[a-1][b-1];
}
