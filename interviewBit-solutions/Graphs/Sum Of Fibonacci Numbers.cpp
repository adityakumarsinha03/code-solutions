/*

How many minimum numbers from fibonacci series are required such that sum of numbers should be equal to a given Number N?
Note : repetition of number is allowed.

Example:

N = 4
Fibonacci numbers : 1 1 2 3 5 .... so on
here 2 + 2 = 4 
so minimum numbers will be 2 

*/

Solution:

int fibbo(int n){
    
    int count1 = 0;
    vector<int>dp;
    dp.push_back(1);
    dp.push_back(1);
    
    for(int i = 2; dp[i-1]<n; i++){
        dp.push_back(dp[i-1]+dp[i-2]);
    }
    int j = dp.size()-1;
    int m  = n;
    while(m>0){
        while(m<dp[j]){
            j--;
        }
        m = m-dp[j];
        count1++;
    }
    return count1;
}

int Solution::fibsum(int n){
    
    return fibbo(n);
    
}
