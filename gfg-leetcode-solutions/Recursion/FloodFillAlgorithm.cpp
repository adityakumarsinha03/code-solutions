// https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/1
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    void floodFillUtil(vector<vector<int>>& image, int sr, int sc, int newColor, vector<vector<int>>& ans, vector<vector<int>>& vis, int m, int n, int val){
        if(sr<0 || sr>=m || sc<0 || sc>=n || vis[sr][sc] == 1 || image[sr][sc] != val)
            return;
            
        vis[sr][sc] = 1;
        ans[sr][sc] = newColor;
        floodFillUtil(image, sr+1, sc, newColor, ans, vis, m, n, val);
        floodFillUtil(image, sr, sc+1, newColor, ans, vis, m, n, val);
        floodFillUtil(image, sr-1, sc, newColor, ans, vis, m, n, val);
        floodFillUtil(image, sr, sc-1, newColor, ans, vis, m, n, val);
    }
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        int m = image.size();
        int n = image[0].size();
        
        int val = image[sr][sc];
        vector<vector<int>> ans = image;
        vector<vector<int>> vis(m, vector<int>(n, 0));
        floodFillUtil(image, sr, sc, newColor, ans, vis, m, n, val);
        return ans;
    }
};

int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, m;
		cin >> n >> m;
		vector<vector<int>>image(n, vector<int>(m,0));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++)
				cin >> image[i][j];
		}
		int sr, sc, newColor;
		cin >> sr >> sc >> newColor;
		Solution obj;
		vector<vector<int>> ans = obj.floodFill(image, sr, sc, newColor);
		for(auto i: ans){
			for(auto j: i)
				cout << j << " ";
			cout << "\n";
		}
	}
	return 0;
}