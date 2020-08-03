// Maximum Flow Problem

#include<bits/stdc++.h>
using namespace std;

bool bfsUtil(vector<vector<int> >&resGraph, int s, int t, vector<int>&parent){
    
    int v = resGraph.size();
    vector<bool>visited(v, false);
    queue<int>q;
    q.push(s);
    
    int u;
    while(!q.empty()){
        u = q.front();
        q.pop();
        for(int i = 0; i<v; i++){
            if(visited[i]==false && resGraph[u][i]>0){
                q.push(i);
                parent[i] = u;
                visited[i] = true;
            }
        }
    }
    if(visited[t]==true)
        return true;
    else
        return false;
}

int fordFulkerson(vector<vector<int> >&graph, int s, int t){
    
    vector<vector<int> >resGraph = graph;
    int v = graph.size();
    vector<int>parent(v, -1);
    
    int u;
    int max_flow = 0;
    while(bfsUtil(resGraph, s, t, parent)==true){
        
        int path_flow = INT_MAX;
        for(int i = t; i!=s; i = parent[i]){
            u = parent[i];
            path_flow = min(path_flow, resGraph[u][i]);
        }
        for(int i = t; i!=s; i = parent[i]){
            u = parent[i];
            resGraph[u][i] = resGraph[u][i] - path_flow;
            resGraph[i][u] = resGraph[i][u] + path_flow;
        }
        max_flow = max_flow + path_flow;
    }
    return max_flow;
}

int main(){
    int v, e;
    cin >> v >> e;
    vector<vector<int> >graph(v, vector<int>(v, 0));
    
    int x, y, z;
    for(int i = 0; i<e; i++){
        cin >> x >> y >> z;
        if(x != y){
            graph[x-1][y-1] += z;
            graph[y-1][x-1] += z;
        }
    }
    int source = 0;
    int sink = v-1;
    int ans = fordFulkerson(graph, source, sink);
    cout << ans << endl;
	return 0;
}