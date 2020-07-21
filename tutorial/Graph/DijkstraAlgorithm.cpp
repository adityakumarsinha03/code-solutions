// Dijkstra algorithm is used to 
// find the minimum distance of all the nodes from the source

// Time Complexity: O(E*log(V))

typedef pair<int, int> PII;

void dijkstra(vector<vector<int>> graph, int src, int n){
    
    priority_queue<PII, vector<PII>, greater<PII> > pq;
    
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