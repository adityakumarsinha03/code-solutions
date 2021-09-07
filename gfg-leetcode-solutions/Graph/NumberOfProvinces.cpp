// https://leetcode.com/problems/number-of-provinces/

class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        
        vector<int> vis(n, 0);
        
        queue<int> q;
        int count = 0;
        for(int i = 0; i<n; i++){
            if(vis[i] == 0){
                count++;
                
                q.push(i);
                vis[i] = 1;
                while(!q.empty()){
                    int x = q.front();
                    q.pop();
                    
                    for(int j = 0; j<n; j++){
                        if(isConnected[x][j]==1 && vis[j] == 0){
                            q.push(j);
                            vis[j] = 1;
                        }   
                    }
                }
            }
        }
        return count;
    }
};