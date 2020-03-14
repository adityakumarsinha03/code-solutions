/*

Given a N cross M matrix in which each row is sorted, find the overall median of the matrix. Assume N*M is odd.

For example,

Matrix=
[1, 3, 5]
[2, 6, 9]
[3, 6, 9]

A = [1, 2, 3, 3, 5, 6, 6, 9, 9]

Median is 5. So, we return 5.
Note: No extra memory is allowed.

*/

Solution:

int Solution::findMedian(vector<vector<int> > &a){
    
    int m = a.size();
    int n = a[0].size();
    
    // Find the minimum
    int minm = INT_MAX;
    for(int i = 0; i<m; i++){
        minm = min(minm, a[i][0]);
    }
    // Find the maximum
    int maxm = INT_MIN;
    for(int i = 0; i<m; i++){
        maxm = max(maxm, a[i][n-1]);
    }
    int mid;
    int count1;
    
    // Desired number of elements for median
    int reqd = (1+(m*n))/2;
    
    while(minm<maxm){
        mid = (minm+maxm)/2;
        count1 = 0;
        for(int i = 0; i<m; i++){
            int y = upper_bound(a[i].begin(), a[i].end(), mid)-a[i].begin();
            count1+=y;
        }
        if(count1<reqd){
            minm = mid+1;
        }
        else{
            maxm = mid;
        }
    }
    return minm;
}
