// Bellman Ford works for negative weighted graph unlike Dijkstra
// Used to find negative cycle

// Time Complexity: O(V*E)

#include<bits/stdc++.h>
using namespace std;

void bellmanFord(vector<pair<int, pair<int, int> > > a, int v, int e, int src){
    vector<int> dist(v, INT_MAX);
    dist[src] = 0;
    
    for(int i = 1; i<v; i++){
        for(int j = 0; j<e; j++){
            int x = a[j].second.first;
            int y = a[j].second.second;
            int weight = a[j].first;
            if(dist[x] != INT_MAX && dist[x] + weight < dist[y]){
                dist[y] = dist[x] + weight;
            }
        }
    }
    for(int j = 0; j<e; j++){
        int x = a[j].second.first;
        int y = a[j].second.second;
        int weight = a[j].first;
        if(dist[x] != INT_MAX && dist[x] + weight < dist[y]){
            cout << "Graph Contains Negative Cycle" << endl;
            return;
        }
    }
    cout << "No Negative Cycle" << endl;
}
int main(){
    int v, e;
    cin >> v >> e;
    vector<pair<int, pair<int, int> > > a;
    int x, y, weight;
    for(int i = 0; i<e; i++){
        cin >> x >> y >> weight;
        a.push_back(make_pair(weight, make_pair(x, y)));
    }
    bellmanFord(a, v, e, 0);
	return 0;
}