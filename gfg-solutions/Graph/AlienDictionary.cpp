// https://practice.geeksforgeeks.org/problems/alien-dictionary/1

/*
dict : array of strings denoting the words in alien langauge
N : Size of the dictionary
K : Number of characters
*/
void topoSortUtil(vector<vector<int> > &vec, int v, vector<int> &vis, stack<int> &recStack){
    vis[v] = 1;
    for(int i = 0; i<vec[v].size(); i++){
        int p = vec[v][i];
        if(vis[p] == 0)
            topoSortUtil(vec, p, vis, recStack);
    }
    recStack.push(v);
}
string topoSort(vector<vector<int> > vec, int k){
    vector<int> vis(k, 0);
    stack<int> recStack;
    for(int i = 0; i<k; i++){
        if(vis[i] == 0)
            topoSortUtil(vec, i, vis, recStack);
    }
    string s = "";
    while(!recStack.empty()){
        s = s + char(recStack.top() + 'a');
        recStack.pop();
    }
    return s;
}
string findOrder(string dict[], int n, int k) {
    
    vector<vector<int> > vec(k);
    for(int i = 0; i<n-1; i++){
        for(int j = 0; j<min(dict[i].length(), dict[i+1].length()); j++){
            if(dict[i][j] != dict[i+1][j]){
                int x = (int)dict[i][j] - 97;
                int y = (int)dict[i+1][j] - 97;
                vec[x].push_back(y);
                break;
            }
        }
    }
    string ans = topoSort(vec, k);
    return ans;
}