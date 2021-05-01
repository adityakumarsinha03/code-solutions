// https://practice.geeksforgeeks.org/problems/circle-of-strings4530/1

// EULER CIRCUIT

#include <bits/stdc++.h>
using namespace std;

class Solution
{
    public:
    void dfs(vector<vector<int> > &gr, vector<int> &vis, int v){
        vis[v] = 1;
        
        for(int i = 0; i<gr[v].size(); i++){
            if(vis[gr[v][i]] == 0)
                dfs(gr, vis, gr[v][i]);
        }
    }
    int stronglyConn(vector<vector<int> > &gr, int len, vector<int> &mark, int s){
        vector<int> vis(len, 0);
        
        dfs(gr, vis, s);
        for(int i = 0; i<len; i++){
            if(mark[i] == 1 && vis[i] == 0)
                return 0;
        }
        return 1;
    }
    int isCircle(int N, vector<string> A)
    {
        int len = 26;
        vector<int> in(26, 0);
        vector<int> mark(26, 0);
        
        vector<vector<int> > gr(len);
        for(int i = 0; i<A.size(); i++){
            char a1 = A[i][0];
            char a2 = A[i][A[i].length()-1];
            gr[(int)a1-'a'].push_back((int)a2-'a');
            in[(int)a2-'a']++;
            mark[(int)a1-'a'] = 1;
            mark[(int)a2-'a'] = 1;
        }
        
		// EULER CIRCUIT
        // Condition-1: check if in-degree == out-degree
        for(int i = 0; i<len; i++){
            if(gr[i].size() != in[i])
                return 0;
        }
        
        // Condition-2: check strongly connected
        if(stronglyConn(gr, len, mark, A[0][0] - 'a') == 0)
            return 0;
            
        return 1;
    }
};

int main()
{
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>>N;
        vector<string> A;
        string s;
        
        for(int i = 0;i < N; i++)
        {
            cin>>s;
            A.push_back(s);
        }
        
        Solution ob;
        cout<<ob.isCircle(N, A)<<endl;
    }
    return 0;
}
