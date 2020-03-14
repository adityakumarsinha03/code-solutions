// https://practice.geeksforgeeks.org/problems/find-whether-path-exist/0

#include<bits/stdc++.h>
using namespace std;

void isPathUtil(vector<vector<int> >a, int n, vector<vector<int> > &vis, int r, int s){
    
    if(r<0 || s<0 || r>=n || s>=n){
        return;
    }
    if(vis[r][s]==1 || a[r][s]==0){
        return;
    }
    vis[r][s] = 1;
    isPathUtil(a, n, vis, r, s+1);
    isPathUtil(a, n, vis, r+1, s);
    isPathUtil(a, n, vis, r, s-1);
    isPathUtil(a, n, vis, r-1, s);
}
int isPath(vector<vector<int> >a, int n, int str, int stc, int enr, int enc) {

    vector<vector<int> > vis(n, vector<int>(n, 0));
    
    isPathUtil(a, n, vis, str, stc);
    if(vis[enr][enc]==1){
        return 1;
    }
    return 0;
}
int main(){
	
	int t;
	cin >> t;
	while(t--){
	    int n;
	    cin >> n;
	    
	    int str = 0, stc = 0;
	    int enr = 0, enc = 0;
	    vector<vector<int> >a(n, vector<int>(n));
	    for(int i = 0; i<n; i++){
	        for(int j = 0; j<n; j++){
    	        cin >> a[i][j];
    	        if(a[i][j] == 1){
    	            str = i; stc = j;
    	        } else if(a[i][j] == 2){
    	            enr = i; enc = j;
    	        }
    	    }
	    }
	    cout << isPath(a, n, str, stc, enr, enc) << endl;
	}
	return 0;
}