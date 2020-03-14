/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example:
Given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
For this problem, return the maximum sum.

*/

Solution:

int Solution::maxSubArray(const vector<int> &a) {
    
    vector<int>b = a;
 
    // Kadane's Algorithm
    int n = a.size();
    int flag = 0;
    
    for(int i = 0; i<n; i++){
        if(a[i] > 0){
            flag = 1;
            break;
        }
    }
    if(flag == 0){
        int x = *max_element(b.begin(), b.end());
        return x;
    }
    else{
        int sum = 0;
        int maxm = 0;
        for(int i = 0; i<n; i++){
            sum = sum + b[i];
            if(sum < 0){
                sum = 0;
            }
            else if(sum > maxm){
                maxm = sum;
            }
        }
        return maxm;
    }
}
