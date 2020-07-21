#include <bits/stdc++.h>
using namespace std;

const int MAX = 1e4 + 5;
typedef pair<long long, int> PII;

long long prims(vector<vector<PII> > a, vector<bool> visited, int x){
    priority_queue<PII, vector<PII>, greater<PII> > pq;

    pair<long long, int> p;
    long long minCost = 0;

    pq.push(make_pair(0, x));
    while(!pq.empty()){
        p = pq.top();
        pq.pop();

        x = p.second;
        if(visited[x] == true)
            continue;
        else{
            minCost += p.first;
            visited[x] = true;
            for(int i = 0; i < a[x].size(); i++){
                int y = a[x][i].second;
                if(visited[y] == false)
                    pq.push(a[x][i]);
            }
        }
    }
    return minCost;
}

long long primsSimilarToDijkstra(vector<vector<PII> > a, int src, int v){
    priority_queue<PII, vector<PII>, greater<PII> > pq;

    vector<long long> dist(v, INT_MAX);
    vector<int> parent(v, -1);
    vector<bool> inMST(v, false);

    pq.push(make_pair(0, src));
    dist[src] = 0;

    long long minCost = 0;
    while(!pq.empty()){
        int u = pq.top().second;
        pq.pop();

        inMST[u] = true;
        for(int i = 0; i<a[u].size(); i++){
            int ver = a[u][i].second;
            long long weight = a[u][i].first;
            if(inMST[ver] == false && dist[ver] > weight){
                dist[ver] = weight;
                pq.push(make_pair(dist[ver], ver));
                parent[ver] = u;
            }
        }
    }
    // Print edges of MST using parent array 
    for (int i = 1; i < v; i++){
        // printf("%d - %d\n", parent[i], i);
        minCost += dist[i];
    }
    
    return minCost;
}

int main()
{
    int v, e;
    cin >> v >> e;
    vector<vector<PII> > a(MAX);
    int x, y, cost;
    for(int i = 0; i<e; i++){
        cin >> x >> y >> cost;
        a[x-1].push_back(make_pair(cost, y-1));
        a[y-1].push_back(make_pair(cost, x-1));
    }
    
    vector<bool> visited(MAX, false);
    int startInd = 1;
    // long long ans = prims(a, visited, startInd);
    long long ans = primsSimilarToDijkstra(a, 0, v);
    cout << ans << endl;
    return 0;
}
