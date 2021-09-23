// https://www.hackerrank.com/challenges/jack-goes-to-rapture/problem

#include <bits/stdc++.h>
using namespace std;

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

/*
 * Complete the 'getCost' function below.
 *
 * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
 */

/*
 * For the weighted graph, <name>:
 *
 * 1. The number of nodes is <name>_nodes.
 * 2. The number of edges is <name>_edges.
 * 3. An edge exists between <name>_from[i] and <name>_to[i]. The weight of the edge is <name>_weight[i].
 *
 */

void getCost(int g_nodes, vector<int> g_from, vector<int> g_to, vector<int> g_weight) {
    // Print your answer within the function and return nothing
	
	// MODIFIED DIJKSTRA'S ALGORITHM
    if(g_from.size() <= 1)
        cout << 0 << endl;
        
    vector<vector<pair<int, int> > > mat(g_nodes);
    for(int i = 0; i<g_from.size(); i++){
        mat[g_from[i]-1].push_back(make_pair(g_to[i]-1, g_weight[i]));
        mat[g_to[i]-1].push_back(make_pair(g_from[i]-1, g_weight[i]));
    }
    
    priority_queue<pair<long long, pair<long long, long long> >,  vector<pair<long long, pair<long long, long long> > >, greater<pair<long long, pair<long long, long long> > > > pq;
    pq.push(make_pair(0, make_pair(0, 0)));
    
    vector<long long> vis(g_nodes, 0);
    vector<long long> dist(g_nodes, INT_MAX);
    dist[0] = 0;
    
    while(!pq.empty()){
        pair<long long, pair<long long, long long> > p = pq.top();
        pq.pop();
        
        // cout << "Here: " << p.first << " " << p.second.first << " " << p.second.second << endl;
        if(p.second.first != 0){
            long long b = 0;
            dist[p.second.first] = min(dist[p.second.first], max(b, p.first - dist[p.second.second]) + dist[p.second.second]);
            // cout << "Updated: " << p.second.first << " " << dist[p.second.first] << endl;
        }
        
        long long src = p.second.first;
        if(vis[src] != 1){
            vis[src] = 1;
            for(int i = 0; i<mat[src].size(); i++){
                pair<long long, pair<long long, long long> > nb = make_pair(mat[src][i].second, make_pair(mat[src][i].first, src));
                pq.push(nb);
            }
        }
    }
    
    // for(int i = 0; i<g_nodes; i++)
    //     cout << dist[i] << " ";
    // cout << endl;
    
    if(dist[g_nodes-1] == INT_MAX)
        cout << "NO PATH EXISTS" << endl;
    else {
        cout << dist[g_nodes-1] << endl;
    }
}

int main()
{
    string g_nodes_edges_temp;
    getline(cin, g_nodes_edges_temp);

    vector<string> g_nodes_edges = split(rtrim(g_nodes_edges_temp));

    int g_nodes = stoi(g_nodes_edges[0]);
    int g_edges = stoi(g_nodes_edges[1]);

    vector<int> g_from(g_edges);
    vector<int> g_to(g_edges);
    vector<int> g_weight(g_edges);

    for (int i = 0; i < g_edges; i++) {
        string g_from_to_weight_temp;
        getline(cin, g_from_to_weight_temp);

        vector<string> g_from_to_weight = split(rtrim(g_from_to_weight_temp));

        int g_from_temp = stoi(g_from_to_weight[0]);
        int g_to_temp = stoi(g_from_to_weight[1]);
        int g_weight_temp = stoi(g_from_to_weight[2]);

        g_from[i] = g_from_temp;
        g_to[i] = g_to_temp;
        g_weight[i] = g_weight_temp;
    }

    getCost(g_nodes, g_from, g_to, g_weight);

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}

vector<string> split(const string &str) {
    vector<string> tokens;

    string::size_type start = 0;
    string::size_type end = 0;

    while ((end = str.find(" ", start)) != string::npos) {
        tokens.push_back(str.substr(start, end - start));

        start = end + 1;
    }

    tokens.push_back(str.substr(start));

    return tokens;
}
