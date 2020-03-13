// https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room/0

#include<bits/stdc++.h>
using namespace std;
int main(){
	
	int t;
	cin >> t;
	while(t--){
	    int n;
	    cin >> n;
	    vector<int>st(n);
	    for(int i = 0; i<n; i++){
	        cin >> st[i];
	    }
	    vector<int>en(n);
	    for(int i = 0; i<n; i++){
	        cin >> en[i];
	    }
	    
	    vector<pair<int, int> >pvec(n);
	    map<pair<int, int>, int> mp;
	    for(int i = 0; i<n; i++){
	        pvec[i] = make_pair(en[i], st[i]);
	        if(mp.find(pvec[i]) == mp.end()){
	            mp[pvec[i]] = i;
	        }
	    }
	    
	    sort(pvec.begin(), pvec.end());
	    
	    cout << mp[pvec[0]]+1 << " ";
	    int i = 0, j = 1;
	    while(i<n && j<n){
	        if(pvec[i].first <= pvec[j].second){
	            cout << mp[pvec[j]]+1 << " ";
	            i = j;
	            j++;
	        } else{
	            j++;
	        }
	    }
	    cout << endl;
	}
	return 0;
}