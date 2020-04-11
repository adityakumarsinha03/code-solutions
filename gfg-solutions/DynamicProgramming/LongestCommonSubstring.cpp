// https://practice.geeksforgeeks.org/problems/longest-common-substring/0

#include<bits/stdc++.h>
using namespace std;
int main(){
	
	int t;
	cin >> t;
	while(t--){
	    int m, n;
	    cin >> m >> n;
	    string s1, s2;
	    cin >> s1 >> s2;
	    
	    vector<vector<int> > dp(m+1, vector<int>(n+1, 0));
	    for(int i = 0; i<=m; i++)
	        dp[i][0] = 0;
	        
	    for(int j = 0; j<=n; j++)
	        dp[0][j] = 0;
	        
	    int ans = 0;
	    for(int i = 1; i<=m; i++){
	        for(int j = 1; j<=n; j++){
	            if(s1[i-1]==s2[j-1]){
	                dp[i][j] = dp[i-1][j-1] + 1;
	                ans = max(ans, dp[i][j]);
	            }
	        }
	    }
	    cout << ans << endl;
	}
	return 0;
}