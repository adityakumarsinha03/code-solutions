/*

Given an array of integers, find the length of longest subsequence which is first increasing then decreasing.

**Example: **

For the given array [1 11 2 10 4 5 2 1]

Longest subsequence is [1 2 10 4 2 1]

Return value 6

*/

Solution:

vector<int> longestIncSub(const vector<int>&a){
    int n = a.size();
    vector<int>d(n, 1);
    for(int i = 1; i<n; i++){
        for(int j = 0; j<i; j++){
            if(a[j]<a[i]){
                d[i] = max(d[i], d[j]+1);
            }
        }
    }
    return d;
}

int Solution::longestSubsequenceLength(const vector<int> &a) {
    int n = a.size();
    if(n <= 1){
        return n;
    }
    vector<int>b(n);
    vector<int>c(n);
    b = longestIncSub(a);
    vector<int>e = a;
    reverse(e.begin(), e.end());
    c = longestIncSub(e);
    reverse(c.begin(), c.end());
    
    int temp;
    int maxm = -1;
    for(int i = 0; i<n; i++){
        temp = b[i]+c[i];
        if(temp>maxm){
            maxm = temp;
        }
    }
    return maxm-1;
}
