// https://practice.geeksforgeeks.org/problems/shortest-source-to-destination-path/0

bool isSafe(vector<vector<int> >&a, int m, int n, int x, int y){
    if(x<0 || y<0 || x>=m || y>=n){
        return false;
    }
    return true;
}
void dfsUtil(vector<vector<int> >&a, vector<vector<int> >&visited, int m, int n, 
                int fx, int fy, int &ans, int count1, int x, int y, int &flag){

    if(x==fx && y==fy && a[x][y]==1){
        flag = 1;
        ans = min(ans, count1);
        return;
    }
    if(isSafe(a, m, n, x, y)==false || a[x][y]==0 || visited[x][y]==1){
        return;
    }
    visited[x][y] = 1;
    dfsUtil(a, visited, m, n, fx, fy, ans, count1+1, x-1, y, flag);
    dfsUtil(a, visited, m, n, fx, fy, ans, count1+1, x, y+1, flag);
    dfsUtil(a, visited, m, n, fx, fy, ans, count1+1, x+1, y, flag);
    dfsUtil(a, visited, m, n, fx, fy, ans, count1+1, x, y-1, flag);
    visited[x][y] = 0;
}
int main(){
	
	int t;
	cin >> t;
	while(t--){
	    int m;
        int n;
        cin >> m >> n;
        vector<vector<int> >a(m, vector<int>(n));
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                cin >> a[i][j];
            }
        }
        vector<vector<int> >visited(m, vector<int>(n, false));
        int x, y;
        cin >> x >> y;
        int ans = INT_MAX;
        int flag = 0;
        dfsUtil(a, visited, m, n, x, y, ans, 0, 0, 0, flag);
        if(flag == 0){
            ans = -1;
        }
        cout << ans << endl;
	}
	return 0;
}