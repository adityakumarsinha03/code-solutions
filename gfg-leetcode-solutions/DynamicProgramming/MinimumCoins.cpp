// https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins/0

#include<bits/stdc++.h>
using namespace std;
int main(){
	
	int t;
	cin >> t;
	
	int coins[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
	vector<int>dp(1000000, 0);
	dp[0] = 1; dp[1] = 1; dp[4] = 1;
	dp[9] = 1; dp[19] = 1; dp[49] = 1;
	dp[99] = 1; dp[199] = 1; dp[499] = 1; dp[1999] = 1;
	
	vector<int> last(1000000, 0);
	int temp = INT_MAX;
	int ind = 0;
    for(int i = 0; i<1000000; i++){
        if(dp[i] != 1){
            temp = INT_MAX;
            for(int j = 0; j<10; j++){
                if(i-coins[j] >= 0 && temp>dp[i-coins[j]]+1){
                    temp = dp[i-coins[j]]+1;
                    last[i] = i-coins[j];
                }
            }
            dp[i] = temp;
        }
    }
	while(t--){
	    int n;
	    cin >> n;
	    
	    vector<int> ans;
	    while(last[n-1]>0){
	        ans.push_back(n-last[n-1]-1);
	        n = last[n-1]+1;
	    }
	    ans.push_back(n);
	    reverse(ans.begin(), ans.end());
	    for(int i = 0; i<ans.size(); i++){
	        cout << ans[i] << " ";
	    } cout << endl;
	}
	return 0;
}