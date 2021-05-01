// https://practice.geeksforgeeks.org/problems/subset-sum-problem/0

#include<bits/stdc++.h>
using namespace std;
int main(){
	
	int t;
	cin >> t;
	while(t--){
	    int m;
	    cin >> m;
	    vector<int>a(m);
	    int sum = 0;
	    for(int i = 0; i<m; i++){
	        cin >> a[i];
	        sum += a[i];
	    }
	    if(sum%2 == 1)
	        cout << "NO" << endl;
	    else{
	        int n = sum/2;
	        vector<vector<int> > dp(m+1, vector<int>(n+1, 0));
    	    for(int i = 0; i<=m; i++)
    	        dp[i][0] = 1;
    	        
    	    int x;
    	    for(int i = 1; i<=m; i++){
    	        for(int j = 1; j<=n; j++){
    	            x = (j-a[i-1] >= 0) ? (dp[i-1][j-a[i-1]]) : (0);
    	            if(dp[i-1][j]>0 || x>0)
    	                dp[i][j] = 1;
    	        }
    	    }
    	    if(dp[m][n]>0)
    	        cout << "YES" << endl;
    	    else
    	        cout << "NO" <<  endl;
	    }
	}
	return 0;
}