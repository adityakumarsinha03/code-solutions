// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/
// Assuming there is no parallel edge

/* This function is used to detect a cycle in undirected graph
*  adj[]: array of vectors to represent graph
*  V: number of vertices
*/
bool isCyclicUtil(int s, vector<int> adj[], vector<int> vis, int parent){
    
    vis[s] = 1;
    for(int i = 0; i<adj[s].size(); i++){
        int p = adj[s][i];
        if(vis[p] == 0){
            if(isCyclicUtil(p, adj, vis, s))
                return true;
        }
        else if(p != parent){
            return true;
        }
    }
    return false;
}
bool isCyclic(vector<int> adj[], int n){
   
   vector<int> vis(n, 0);
   for(int i = 0; i<n; i++){
       if(vis[i] == 0 && isCyclicUtil(i, adj, vis, -1))
           return true;
   }
   return false;
}