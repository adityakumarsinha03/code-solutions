// https://practice.geeksforgeeks.org/problems/coin-piles/0

#include<bits/stdc++.h>
using namespace std;
int main(){
	
	int t;
	cin >> t;
	while(t--){
	    int n, k;
	    cin >> n >> k;
	    vector<int>a(n);
	    for(int i = 0; i<n; i++){
	        cin >> a[i];
	    }
	    sort(a.begin(), a.end());
	    
	    int temp = 0;
	    int ans = INT_MAX;
	    int sum = 0;
	    for(int p = 0; p<n-1; p++){
    	    for(int i = p+1; i<n; i++){
    	        if(a[i]-a[p]>k){
    	            temp += (a[i]-a[p])-k;
    	        }
    	    }
    	    ans = min(ans, temp);
    	    temp = sum + a[p];
    	    sum = temp;
	    }
	    cout << ans << endl;
	}
	return 0;
}