// https://practice.geeksforgeeks.org/problems/coin-change/0

#include<bits/stdc++.h>
using namespace std;
int main(){
	
	int t;
	cin >> t;
	while(t--){
	    int m, n;
	    cin >> m;
	    vector<int>a(m);
	    for(int i = 0; i<m; i++){
	        cin >> a[i];
	    }
	    cin >> n;
	    
	    vector<vector<int> > dp(m+1, vector<int>(n+1, 0));
	    for(int i = 0; i<=m; i++)
	        dp[i][0] = 1;
	        
	    int x;
	    for(int i = 1; i<=m; i++){
	        for(int j = 1; j<=n; j++){
	            x = (j-a[i-1] >= 0) ? (dp[i][j-a[i-1]]) : (0);
	            dp[i][j] = x + dp[i-1][j];
	        }
	    }
	    cout << dp[m][n] << endl;
	}
	return 0;
}