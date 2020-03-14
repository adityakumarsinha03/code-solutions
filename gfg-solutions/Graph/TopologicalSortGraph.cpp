// https://practice.geeksforgeeks.org/problems/topological-sort/1

/*  Function which sorts the graph vertices in topological form
*   N: number of vertices
*   adj[]: input graph
*   NOTE: You must return dynamically allocated array
*/
void topoSortUtil(int s, vector<int> adj[], vector<int> &vis, stack<int> &st){
    
    vis[s] = 1;

    for(int i = 0; i<adj[s].size(); i++){
        int p = adj[s][i];
        if(vis[p] == 0)
             topoSortUtil(p, adj, vis, st);
    }
    st.push(s);
}
int* topoSort(int n, vector<int> adj[]) {

    stack<int> st;
    
    vector<int> vis(n, 0);
    for(int i = 0; i<n; i++){
        if(vis[i]==0){
            topoSortUtil(i, adj, vis, st);
        }
    }
    
    int* ans = new int[n];
    int i = 0;
    while(!st.empty()){
        ans[i] = st.top();
        st.pop();
        i++;
    }
    return ans;
}