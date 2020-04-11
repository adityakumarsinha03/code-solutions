// https://practice.geeksforgeeks.org/problems/cutted-segments/0

#include<bits/stdc++.h>
using namespace std;
int main(){
	
	int t;
	cin >> t;
	while(t--){
	    int m = 3, n;
	    cin >> n;
	    vector<int>a(m);
	    for(int i = 0; i<m; i++){
	        cin >> a[i];
	    }
	    sort(a.begin(), a.end());
	    
	    vector<vector<int> > dp(m, vector<int>(n+1, 0));
	    for(int i = 0; i<m; i++)
	        dp[i][0] = 0;
	    
	    for(int j = 0; j<=n; j++){
	        if(j%a[0] == 0)
	            dp[0][j] = j/a[0];
	    }
	    for(int i = 1; i<m; i++){
	        for(int j = 1; j<=n; j++){
	            if(j-a[i] < 0)
	                dp[i][j] = dp[i-1][j];
	            else{
	                if(dp[i-1][j]==0 && j-a[i]>0 && dp[i][j-a[i]]==0)
	                    dp[i][j] = 0;
	                else
	                    dp[i][j] = max(dp[i-1][j], dp[i][j-a[i]]+1);
	            }
	        }
	    }
	    cout << dp[m-1][n] << endl;
	}
	return 0;
}