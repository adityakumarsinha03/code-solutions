#include <bits/stdc++.h>
using namespace std;

#define MAX 100000
vector<int> id(MAX);

void initialise(){
    for(int i = 0; i<MAX; i++){
        id[i] = i;
    }
}

int root(int x){
    while(id[x] != x){
        // id[x] = id[id[x]];
        x = id[x];
    }
    return x;
}

/*void union(int x, int y){
    int p = root(x);
    int q = root(y);
    id[p] = id[q];
}*/

long long kruskal(vector<pair<int, pair<int, int> > > &a, int e){
    
    initialise();
    int x, y, cost;
    long long mincost = 0;
    for(int i = 0; i<e; i++){
        x = a[i].second.first;
        y = a[i].second.second;
        cost = a[i].first;
        
        int p = root(x);
        int q = root(y);
        if(p != q){ // Check cycle
            mincost += cost;
            // union(x, y);
            id[p] = id[q];
        }
    }
    return mincost;
}

int main()
{
    int v, e;
    cin >> v >> e;
    vector<pair<int, pair<int, int> > > a;
    int x, y, cost;
    for(int i = 0; i<e; i++){
        cin >> x >> y >> cost;
        pair<int, pair<int, int> > p = make_pair(cost, make_pair(x-1, y-1));
        a.push_back(p);
    }
    sort(a.begin(), a.end());
    
    long long ans = kruskal(a, e);
    cout << ans << endl;
    return 0;
}
