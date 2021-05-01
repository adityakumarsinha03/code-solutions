// https://practice.geeksforgeeks.org/problems/activity-selection/0

#include<bits/stdc++.h>
using namespace std;

int maxActivity(vector<int>st, vector<int>end){
    
    int n = st.size();
    vector<pair<int, int> > v(n);
    for(int i = 0; i<n; i++){
        v[i] = make_pair(end[i], st[i]);
    }
    sort(v.begin(), v.end());
    
    int ans = 1;
    
    int i = 1, j = 0;
    while(i<n && j<n){
        if(v[j].first <= v[i].second){
            ans++;
            j = i;
            i++;
        } else{
            i++;
        }
    }
    return ans;
}
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
	    vector<int>end(n);
	    for(int i = 0; i<n; i++){
	        cin >> end[i];
	    }
	    
	    cout << maxActivity(st, end) << endl;
	}
	return 0;
}