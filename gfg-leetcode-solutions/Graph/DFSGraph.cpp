// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

/* Function to do DFS of graph
*  g[]: array of vectors to represent graph
*  vis[]: array to keep track of visited vertex
*/
void dfs(int s, vector<int> g[], bool vis[]){
    
    vis[s] = true;
    cout << s << " ";
    
    for(int i = 0; i<g[s].size(); i++){
        if(vis[g[s][i]] == false){
            dfs(g[s][i], g, vis);
        }
    }
}