// https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3719/

// TARJAN'S ALGORITHM

class Solution {
public:
    
    void dfs(vector<vector<int> > gr, vector<int> &prev, vector<int> &low, int n, int u, int v, int &count, vector<vector<int> > &ans){
        prev[v] = count++;
        low[v] = prev[v];
        
        for(int w = 0; w<gr[v].size(); w++){
            int nd = gr[v][w];
            if(prev[nd] == -1){
                dfs(gr, prev, low, n, v, nd, count, ans);
                low[v] = min(low[v], low[nd]);
                if(low[nd] == prev[nd]){
                    ans.push_back(vector<int>({v, nd}));
                }
                
            } else if(nd != u){
                low[v] = min(low[v], prev[nd]);
            }
        }
    }
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        int len = connections.size();
        
        vector<vector<int> > gr(n);
        for(int i = 0; i<len; i++){
            gr[connections[i][0]].push_back(connections[i][1]);
            gr[connections[i][1]].push_back(connections[i][0]);
        }
        
        vector<int> low(n, -1);
        vector<int> prev(n, -1);
        
        int count = 0;
        vector<vector<int> > ans;
        for(int i = 0; i<n; i++){
            if(prev[i] == -1){
                dfs(gr, prev, low, n, i, i, count, ans);
            }
        }
        return ans;
    }
};