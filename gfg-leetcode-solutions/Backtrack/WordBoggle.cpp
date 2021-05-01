#include<bits/stdc++.h>
using namespace std;

int isSafe(int r, int c, int x, int y){
    if(x>=0 && y>=0 && x<r && y<c)
        return 1;
    return 0;
}
void wordBoggle(unordered_map<string, int> a, vector<vector<char> > vec, vector<vector<int> > vis, int x, int y, int r, int c, string s, int maxLen, set<string> &ans){
    if(isSafe(r, c, x, y)==0 || vis[x][y]==1 || s.length()>maxLen){
        return;
    }
    s.push_back(vec[x][y]);
    if(a.find(s) != a.end()){
        ans.insert(s);
    }
    vis[x][y] = 1;
    wordBoggle(a, vec, vis, x+1, y, r, c, s, maxLen, ans);
    wordBoggle(a, vec, vis, x+1, y-1, r, c, s, maxLen, ans);
    wordBoggle(a, vec, vis, x, y-1, r, c, s, maxLen, ans);
    wordBoggle(a, vec, vis, x-1, y-1, r, c, s, maxLen, ans);
    wordBoggle(a, vec, vis, x-1, y, r, c, s, maxLen, ans);
    wordBoggle(a, vec, vis, x-1, y+1, r, c, s, maxLen, ans);
    wordBoggle(a, vec, vis, x, y+1, r, c, s, maxLen, ans);
    wordBoggle(a, vec, vis, x+1, y+1, r, c, s, maxLen, ans);
    vis[x][y] = 0;
    s.pop_back();
}
int main(){
	
	int t;
	cin >> t;
	while(t--){
	    int n;
	    cin >> n;
	    unordered_map<string, int>a;
	    string s;
	    int maxLen = 0;
	    for(int i = 0; i<n; i++){
	        cin >> s;
	        a[s] = 1;
	        int len = s.length();
	        maxLen = max(maxLen, len);
	    }
	    int x, y;
	    cin >> x >> y;
	    vector<vector<char> > vec(x, vector<char>(y));
	    for(int i = 0; i<x; i++){
	        for(int j = 0; j<y; j++){
	            cin >> vec[i][j];
	        }
	    }
	    vector<vector<int> > vis(x, vector<int>(y, 0));
	    set<string> ans;
	    string str = "";
	    for(int i = 0; i<x; i++){
	        for(int j = 0; j<y; j++){
	            wordBoggle(a, vec, vis, i, j, x, y, str, maxLen, ans);
	        }
	    }
	    set<string> :: iterator it;
	    if(ans.size() == 0)
	        cout << -1 << endl;
	    else{
    	    for(it = ans.begin(); it != ans.end(); ++it){
    	        cout << *it << " ";
    	    }
    	    cout << endl;
	    }
	}
	return 0;
}