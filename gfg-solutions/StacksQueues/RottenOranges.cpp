// https://practice.geeksforgeeks.org/problems/rotten-oranges/0

#include<bits/stdc++.h>
using namespace std;

int checkArray(int r, int c, vector<vector<int> > a){
    for(int i = 0; i<r; i++){
        for(int j = 0; j<c; j++){
            if(a[i][j]==1)
                return -1;
        }
    }
    return 0;
}
int main(){
	
	int t;
	cin >> t;
	while(t--){
	    int r, c;
	    cin >> r >> c;
	    vector<vector<int> > a(r, vector<int>(c));
	    queue<pair<int, int> > q1;
	    queue<pair<int, int> > q2;
	    
	    for(int i = 0; i<r; i++){
	        for(int j = 0; j<c; j++){
	            cin >> a[i][j];
	            if(a[i][j]==2)
	                q1.push(make_pair(i, j));
	        }
	    }
	    
	    int dx[] = {1, 0, -1, 0};
	    int dy[] = {0, -1, 0, 1};
	    
	    int newX, newY;
	    int ans = 0;
	    while(!q1.empty() || !q2.empty()){
	        if(!q1.empty()){
    	        while(!q1.empty()){
        	        pair<int, int> temp = q1.front();
        	        q1.pop();
        	        
        	        for(int i = 0; i<4; i++){
        	            newX = temp.first + dx[i];
        	            newY = temp.second + dy[i];
        	            if(newX>=0 && newY>=0 && newX<r && newY<c && a[newX][newY]==1){
        	                q2.push(make_pair(newX, newY));
        	                a[newX][newY] = 2;
        	            }
        	        }
    	        }
    	        if(!q2.empty())
    	            ans++;
	        }
	        if(!q2.empty()){
    	        while(!q2.empty()){
        	        pair<int, int> temp = q2.front();
        	        q2.pop();
        	        
        	        for(int i = 0; i<4; i++){
        	            newX = temp.first + dx[i];
        	            newY = temp.second + dy[i];
        	            if(newX>=0 && newY>=0 && newX<r && newY<c && a[newX][newY]==1){
        	                q1.push(make_pair(newX, newY));
        	                a[newX][newY] = 2;
        	            }
        	        }
    	        }
    	        if(!q1.empty())
    	            ans++;
	        }
	    }
	    if(checkArray(r, c, a)==-1)
	        cout << -1 << endl;
	    else
	        cout << ans << endl;
	    
	}
	return 0;
}