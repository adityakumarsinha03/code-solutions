/*

Find the contiguous subarray within an array (containing at least one number) which has the largest product.
Return an integer corresponding to the maximum product possible.

Example :

Input : [2, 3, -2, 4]
Return : 6 

Possible with [2, 3]

*/

Solution:

int Solution::maxProduct(const vector<int> &a){
    
    int n = a.size();
    if(n == 1 && a[0]<=0){
        return 0;
    }
    int flag = 0;
    for(int i = 0; i<n; i++){ // Check if any positive number is present
        if(a[i] > 0){
            flag = 1;
            break;
        }
    }
    for(int i = 0; i<n-1; i++){ // If no positive number is there, check if two negative numbers are consecutive
        if(a[i] <0 && a[i+1]<0){
            flag = 1;
            break;
        }
    }
    if(flag == 0){ // If both the above check fails, it means answer is 0.
        return 0;
    }
    // Similar to Kadane's Algorithm
    int maxm = 1;
    int minm = 1;
    int res = 0;
    int temp;
    for(int i = 0; i<n; i++){
        if(a[i] > 0){ // If a[i] is positive, maxm and minm are updated simply.
            maxm = maxm*a[i];
            minm = min(1, minm*a[i]);
        }
        else if(a[i] == 0){ // If at somepoint, any a[i] == 0, we reset the maxm and minm values.
            maxm = 1;
            minm = 1;
        }
        else{ // If a[i] < 0, maxm takes minm value (assuming minm < 0) multiplied by a[i]. 
              // If product turns out to be negative, it resets its value.
              // Similarly, minm takes maxm value (assuming maxm > 0) multiplied by a[i].
              // If product turns out to be greater than it initial value, it resets its value.
            temp = maxm;
            maxm = max(minm*a[i], 1);
            minm = temp*a[i];
        }
        res = max(res, maxm);
    }
    return res;
    
// The code below is not efficient, but it is implemented using DP
    /*if(n<=0){
        return 0;
    }
    if(n == 1){
        return a[0];
    }
    long long t[n][n];
    long long ans = *max_element(a.begin(), a.end());
    for(int i = 0; i<n; i++){
        t[i][i] = a[i];
        //ans = max(ans, t[i][i]);
    }
    for(int w = 1; w<n; w++){
        int j = w;
        for(int i = 0; i<n-w; i++){
            t[i][j] = t[i][j-1]*a[j];
            ans = max(ans, t[i][j]);
            j++;
        }
    }
    return ans;*/
}
