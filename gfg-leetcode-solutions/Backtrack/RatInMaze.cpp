// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

#include <bits/stdc++.h>
using namespace std;

#define MAX 5
vector<string> printPath(int m[MAX][MAX], int n);

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;

        int m[MAX][MAX];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> m[i][j];
            }
        }

        vector<string> result = printPath(m, n);
        if (result.size() == 0)
            cout << -1;
        else
            for (int i = 0; i < result.size(); i++) cout << result[i] << " ";
        cout << endl;
    }
    return 0;
}

// MAX is the upper limit of N ie 5
int isSafe(int n, int a[MAX][MAX], int x, int y){
    if(x>=0 && y>=0 && x<n && y<n && a[x][y] == 1)
        return 1;
    return 0;
}
void ratInMaze(int a[MAX][MAX], vector<vector<int> > vis, int x, int y, string s, int n, vector<string> &vec){
    if(x == n-1 && y == n-1 && a[x][y] == 1){
        vec.push_back(s);
        return;
    }
    if(isSafe(n, a, x, y)==0 || vis[x][y]==1){
        return;
    }
    if(isSafe(n, a, x, y) == 1){
        vis[x][y] = 1;
        ratInMaze(a, vis, x-1, y, s+"U", n, vec);
        ratInMaze(a, vis, x, y+1, s+"R", n, vec);
        ratInMaze(a, vis, x+1, y, s+"D", n, vec);
        ratInMaze(a, vis, x, y-1, s+"L", n, vec);
        vis[x][y] = 0;
        return;
    }
    return;
}
vector<string> printPath(int a[MAX][MAX], int n) {
    vector<vector<int> > vis(n, vector<int>(n, 0));
    vector<string> vec;
    
    string s = "";
    ratInMaze(a, vis, 0, 0, s, n, vec);
    sort(vec.begin(), vec.end());
    return vec;
}