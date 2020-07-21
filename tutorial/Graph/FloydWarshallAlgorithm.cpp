// Floyd Warshall is used to find
// shortest distance between all 2 vertices

// Time Complexity: O(V^3)

#include<bits/stdc++.h>
using namespace std;

void floydWarshall(vector<vector<int> >a, int v){
    vector<vector<int> > dist = a;
    for(int k = 0; k<v; k++){
        for(int i = 0; i<v; i++){
            for(int j = 0; j<v; j++){
                if(dist[i][j] > dist[i][k] + dist[k][j])
                    dist[i][j] = dist[i][k] + dist[k][j];
            }
        }
    }
    for(int i = 0; i<v; i++){
        for(int j = 0; j<v; j++){
            cout << dist[i][j] << " ";
        } cout << endl;
    }
}

int main(){
    int v;
    cin >> v;
    vector<vector<int> >a(v, vector<int>(v));
    for(int i = 0; i<v; i++){
        for(int j = 0; j<v; j++){
            cin >> a[i][j];
        }
    }
    floydWarshall(a, v);
	return 0;
}