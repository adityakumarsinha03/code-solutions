/*

 There are a total of N courses you have to take, labeled from 1 to N. Some courses may have prerequisites, 
for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2]. 
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses. 
return 1/0 if it is possible/not possible.
The list of prerequisite pair are given in two integer arrays B and C where B[i] is a prerequisite for C[i].

 Example: If N = 3 and the prerequisite pairs are [1,2] and [2,3], then you can finish courses in the 
 following order: 1, 2 and 3. But if N = 2 and the prerequisite pairs are [1,2] and [2,1], then it is not 
 possible for you to finish all the courses. 

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
        vector<bool> visited;
        vector<bool>recStack;
        bool cycleUtil(int u, vector<bool>&visited, vector<bool>&recStack);
        bool hascycle();
};
 
Graph::Graph(int v){
    this->V = v;
    adj = new list<int>[V];
    visited.resize(V, false);
    recStack.resize(V, false);
}
 
void Graph::addEdge(int src, int dst){
    adj[src].push_back(dst);
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

bool Graph::cycleUtil(int u, vector<bool>&visited, vector<bool>&recStack){
    if(visited[u] == false){
        visited[u] = true;
        recStack[u] = true;
        
        for(list<int>::iterator it = adj[u].begin(); it!=adj[u].end(); ++it){
            if(visited[*it]==false && cycleUtil(*it, visited, recStack)==true){
                return true;
            }
            else if(recStack[*it] == true){
                return true;
            }
        }
    }
    recStack[u] = false;
    return false;
}
bool Graph::hascycle(){
    for(int i = 0; i<V; i++){
        if(cycleUtil(i, visited, recStack)){
            return true;
        }
    }
    return false;
}

int Solution::solve(int a, vector<int> &b, vector<int> &c){
    
    int n = a;
    Graph myGraph(n);
    int k = b.size();
    for(int i = 0; i<k; i++){
        int src = b[i];
        int dst = c[i];
        myGraph.addEdge(src-1, dst-1);
    }
    //  myGraph.printGraph();
    if(myGraph.hascycle() == true){
        return 0;
    }
    else{
        return 1;
    }
}
