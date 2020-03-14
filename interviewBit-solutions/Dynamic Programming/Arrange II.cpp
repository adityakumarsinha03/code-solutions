/*

You are given a sequence of black and white horses, and a set of K stables numbered 1 to K. You have to 
accommodate the horses into the stables in such a way that the following conditions are satisfied:

You fill the horses into the stables preserving the relative order of horses. For instance, you cannot put 
horse 1 into stable 2 and horse 2 into stable 1. You have to preserve the ordering of the horses.
No stable should be empty and no horse should be left unaccommodated.
Take the product (number of white horses * number of black horses) for each stable and take the sum of all 
these products. This value should be the minimum among all possible accommodation arrangements
Example:

Input: {WWWB} , K = 2
Output: 0

Explanation:
We have 3 choices {W, WWB}, {WW, WB}, {WWW, B}
for first choice we will get 1*0 + 2*1 = 2.
for second choice we will get 2*0 + 1*1 = 1.
for third choice we will get 3*0 + 0*1 = 0.

Of the 3 choices, the third choice is the best option. 

If a solution is not possible, then return -1

*/

Solution:

int Solution::arrange(string s, int p){
    
    int n = s.length();
    
    vector<vector<int> >dp(n, vector<int>(p, 0));
    
    if(n<p) 
        return -1;
    else if(n==p) 
        return 0;

    int wt=0, bk=0;
    
    for(int i=0; i<n; i++){
        if(s[i]=='B') 
            bk++;
        else 
            wt++;
        dp[i][0] = (bk*wt);
    }

    for(int j=1; j<p; j++){
        for(int i=0; i<n; i++){
            wt=0, bk=0;
            dp[i][j]=INT_MAX;
            for(int k=i; k>=0; k--){
                if(s[k]=='B') 
                    bk++;
                else 
                    wt++;
                dp[i][j] = min(dp[i][j], bk*wt + ((k-1>=0)?dp[k-1][j-1]:0));
            }
        }
    }
    return dp[n-1][p-1];
}

/* 
    Solution below is correct. But it is solved using Backtracking.
    So, it is leading to TLE.
*/

// void mulminm(string &s, int st, vector<int>&a, int &minm, vector<int>&d, int &k, int &sum, int &n, int &len){
   
//     if(d.size() > k || sum > len){
//         return;
//     }
//     if(d.size() == k && sum == len){
        
//         int nw = 0;
//         int nb = 0;
//         int z = 0;
//         for(int j = 0; j<d[0]; j++){
//             if(s[j]=='W'){
//                 nw++;
//             }
//             else{
//                 nb++;
//             }
//         }
//         z = z + (nb*nw);
//         for(int i = 1; i<d.size(); i++){
//             nb = 0;
//             nw = 0;
//             for(int j = d[i-1]; j<d[i-1]+d[i]; j++){
//                 if(s[j]=='W'){
//                     nw++;
//                 }
//                 else{
//                     nb++;
//                 }
//             }
//             z = z + (nb*nw);
//         }
//         minm = min(minm, z);
//         return;
//     }
//     for(int i = 0; i<n; i++){
//         d.push_back(a[i]);
//         sum+=a[i];
//         mulminm(s, i, a, minm, d, k, sum, n, len);
//         sum-=a[i];
//         d.pop_back();
//     }
// }

// int Solution::arrange(string s, int k){
    
//     int n = s.length();
//     vector<int>a(n-k+1);
	
// 	for(int i = 1; i<=n-k+1; i++){
// 	    a[i-1] = i;
// 	}
// 	vector<int>d;
// 	int minm = INT_MAX;
// 	int sum = 0;
// 	int m = a.size();
// 	int len = n;
// 	if(k>len){
// 	    return -1;
// 	}
// 	else if(k == len){
// 	    int nb = 0;
// 	    int nw = 0;
// 	    for(int j =0; j<len; j++){
//             if(s[j]=='W'){
//                 nw++;
//             }
//             else{
//                 nb++;
//             }
//         }
//         return nb*nw;
// 	}
// 	else{
// 	    mulminm(s, 0, a, minm, d, k, sum, m, len);
// 	    return minm;
// 	}
// }
