// https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

/*  Function to implement Dijkstra
*   graph: vector of vectors which represents the graph
*   src: source vertex to start traversing graph with
*   V: number of vertices
*/
void dijkstra(vector<vector<int>> graph, int src, int n){
    
    priority_queue<pair<int, int>, vector<pair<int, int> >, greater<pair<int, int> > > pq;
    
    vector<int> dis(n, INT_MAX);
    pq.push(make_pair(0, src));
    dis[src] = 0;
    
    while(!pq.empty()){
        int u = pq.top().second;
        pq.pop();
        
        for(int i = 0; i<graph[u].size(); i++){
            int v = i;
            int weight = graph[u][i];
            if(weight>0 && dis[v] > dis[u]+weight){
                dis[v] = dis[u]+weight;
                pq.push(make_pair(dis[v], v));
            }
        }
    }
    for(int i = 0; i<n; i++){
        cout << dis[i] << " ";
    }
}