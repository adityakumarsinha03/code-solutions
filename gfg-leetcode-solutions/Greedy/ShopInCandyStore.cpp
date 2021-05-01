// https://practice.geeksforgeeks.org/problems/shop-in-candy-store/0

#include<bits/stdc++.h>
using namespace std;

void shopInCandyStore(int n, int k, vector<int> vec){
    sort(vec.begin(), vec.end());
    
    int minCost = 0;
    int maxCost = 0;
    int j = 0, p = n-1;
    for(int i = 0; i<n && p>=i; i++){
        minCost += vec[i];
        p -= k;
    }
    for(int i = n-1; i>=0 && j<=i; i--){
        maxCost += vec[i];
        j += k;
    }
    cout << minCost << " " << maxCost << endl;
}
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
	    shopInCandyStore(n, k, a);
	}
	return 0;
}