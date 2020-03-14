/*

Find largest distance
Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes. The goal of the problem is 
to find largest distance between two nodes in a tree. Distance between two nodes is a number of edges on a path 
between the nodes (there will be a unique path between any pair of nodes since it is a tree). 
The nodes will be numbered 0 through N - 1.

The tree is given as an array P, there is an edge between nodes P[i] and i (0 <= i < N). 
Exactly one of the i’s will have P[i] equal to -1, it will be root node.

 Example:
If given P is [-1, 0, 0, 0, 3], then node 0 is the root and the whole tree looks like this: 
          0
       /  |  \
      1   2   3
               \
                4  
 One of the longest path is 1 -> 0 -> 3 -> 4 and its length is 3, thus the answer is 3. Note that 
 there are other paths with maximal distance.

*/

Solution:

#include <bits/stdc++.h>

class Graph{
    int V;
    list<int> *adj;
    
    public:
        // First make constructor
        Graph(int v);
        void addEdge(int src, int dst);
        void printGraph();
        vector<long long>wt;
        vector<bool> visited;
        vector<int> dist;
        void dfsUtil(int src, int d);
        // void dfs();
};
 
Graph::Graph(int v){
    this->V = v;
    adj = new list<int>[V];
    wt.resize(V);
    visited.resize(V, false);
    dist.resize(V, 0);
}
 
void Graph::addEdge(int src, int dst){
    adj[src].push_back(dst);
    adj[dst].push_back(src);
}
 
void Graph::printGraph(){
    for(int i = 0; i<V; i++){
        list<int>::iterator it;
        cout << i << "---> ";
        for(it = adj[i].begin(); it!=adj[i].end(); ++it){
            cout << *it << "-->";
        }
        cout << endl;
    }
}
 
void Graph::dfsUtil(int src, int d){
    
    visited[src] = true;
    dist[src] = max(dist[src], d);
    list<int>::iterator it;
    for(it = adj[src].begin(); it != adj[src].end(); ++it){
        if(!visited[*it]){
            dfsUtil(*it, d+1);
        }
    }
}
 
/*void Graph::dfs(){
    for(int i = 0; i<V; i++){
        for(int j = 0; j<V; j++){
            visited[j] = false;
        }
        int d = 0;
        dfsUtil(i, dist, d);
    }
}*/

int Solution::solve(vector<int> &a) {
    
    int n = a.size();
    if(n == 1 && a[0] == -1){
        return 0;
    }
    Graph myGraph(n);
    int rootNode;
    for(int i = 0; i<n; i++){
        int src, dst;
        if(a[i] != -1){
            src = a[i];
            dst = i;
            myGraph.addEdge(src, dst);
        }
        else{
            rootNode = i;
        }
    }
    // myGraph.printGraph();
    int d = 0;
    myGraph.dfsUtil(rootNode, d);
    int maxdist1 = -1;
    int rootNode2;
    for(int i = 0; i<n; i++){
        if(myGraph.dist[i] > maxdist1){
            maxdist1 = myGraph.dist[i];
            rootNode2 = i;
        }
    }
    
    for(int i = 0; i<n; i++){
        myGraph.visited[i] = false;
        myGraph.dist[i] = 0;
    }
    int d2 = 0;
    myGraph.dfsUtil(rootNode2, d2);
    int maxdist2 = -1;
    for(int i = 0; i<n; i++){
        if(myGraph.dist[i] > maxdist2){
            maxdist2 = myGraph.dist[i];
        }
    }
    int totdist = max(maxdist1, maxdist2);
    return totdist;
}
