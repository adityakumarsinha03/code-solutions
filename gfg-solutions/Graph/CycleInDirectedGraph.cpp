// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

/*  Function to check if the given graph contains cycle
*   V: number of vertices
*   adj[]: representation of graph
*/
bool isCyclicUtil(int s, vector<int> adj[], vector<int> vis, vector<int> recStack){
    if(vis[s] == 0){
        vis[s] = 1;
        recStack[s] = 1;
        
        for(int i = 0; i<adj[s].size(); i++){
            int p = adj[s][i];
            if(vis[p]==0 && isCyclicUtil(p, adj, vis, recStack))
                return true;
            else if(recStack[p]==1)
                return true;
        }
    }
    recStack[s] = 0;
    return false;
}
bool isCyclic(int V, vector<int> adj[]){
    int n = V;
    vector<int> vis(n, 0);
    vector<int> recStack(n, 0);
    
    for(int i = 0; i<n; i++){
        if(isCyclicUtil(i, adj, vis, recStack))
            return true;
    }
    return false;
}