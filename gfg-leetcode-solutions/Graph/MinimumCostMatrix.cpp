#include<bits/stdc++.h>
using namespace std;

struct cell 
{ 
    int x, y; 
    int distance; 
    cell(int x, int y, int distance) : 
        x(x), y(y), distance(distance) {} 
}; 

bool operator<(const cell& a, const cell& b) {
    if (a.distance == b.distance) 
    { 
        if (a.x != b.x) 
            return (a.x < b.x); 
        else
            return (a.y < b.y); 
    } 
    return (a.distance < b.distance); 
} 
bool isSafe(int i, int j, int n) { 
    return (i >= 0 && i < n && j >= 0 && j < n); 
}
/*
// Priority queue is giving TLE on submission

int minDist(vector<vector<int> > graph, int src, int n){
        
    int dx[] = {-1, 0, 1, 0}; 
    int dy[] = {0, 1, 0, -1}; 
    
    priority_queue<cell> pq;
    vector<vector<int> > dis(n, vector<int>(n, INT_MAX));
    
    pq.push(cell(0, 0, 0));
    dis[0][0] = graph[0][0];
    
    while(!pq.empty()){
        cell k = pq.top();
        pq.pop();
        
        for(int i = 0; i<4; i++){
            int x = k.x + dx[i]; 
            int y = k.y + dy[i]; 
            
            if (!isSafe(x, y, n)) 
                continue;
            
            int weight = graph[x][y];
            if(dis[x][y]==INT_MAX || dis[x][y] > dis[k.x][k.y]+weight){
                dis[x][y] = dis[k.x][k.y]+weight;
                pq.push(cell(x, y, dis[x][y]));
            }
        }
    }
    
    return dis[n-1][n-1]; 
}*/

int minDist(vector<vector<int> > graph, int src, int n) { 
    
    vector<vector<int> > dis(n, vector<int>(n, INT_MAX));
  
    int dx[] = {-1, 0, 1, 0}; 
    int dy[] = {0, 1, 0, -1}; 
  
    set<cell> st; 
    st.insert(cell(0, 0, 0)); 
  
    dis[0][0] = graph[0][0]; 
  
    while (!st.empty()){ 
        cell k = *st.begin(); 
        st.erase(st.begin()); 
  
        for (int i = 0; i < 4; i++) { 
            int x = k.x + dx[i]; 
            int y = k.y + dy[i]; 
  
            if (!isSafe(x, y, n)) 
                continue; 
                
            int weight = graph[x][y];
            if (dis[x][y] > dis[k.x][k.y] + weight) 
            { 
                if (dis[x][y] != INT_MAX) 
                    st.erase(st.find(cell(x, y, dis[x][y]))); 
  
                dis[x][y] = dis[k.x][k.y] + weight; 
                st.insert(cell(x, y, dis[x][y])); 
            } 
        } 
    } 
    return dis[n-1][n-1]; 
} 

int main(){
	
	int t;
	cin >> t;
	while(t--){
	    int n;
	    cin >> n;
	    vector<vector<int> >a(n, vector<int>(n));
	    for(int i = 0; i<n; i++){
	        for(int j = 0; j<n; j++){
    	        cin >> a[i][j];
    	    }
	    }
	    cout << minDist(a, 0, n) << endl;
	}
	return 0;
}