// https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

/* Function to do BFS of graph
*  adj[]: array of vectors
*  vis[]: array to keep track of visited nodes
*/
void bfs(int s, vector<int> adj[], bool vis[], int N)
{
    queue<int> q;
    
    vis[s] = true;
    q.push(s);
    
    while(!q.empty()){
        int x = q.front();
        cout << x << " ";
        q.pop();
        
        for(int i = 0; i<adj[x].size(); i++){
            if(vis[adj[x][i]] == false){
                vis[adj[x][i]] = true;
                q.push(adj[x][i]);
            }
        }
    }
}