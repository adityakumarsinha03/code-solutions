// https://practice.geeksforgeeks.org/contest-problem/game-of-corners/1/

bool ValidCorner(const vector<vector<int> >& a){
    
    int n = a.size();
    int m = a[0].size();
    
    map<pair<int, int>, int > mp;
    for(int i = 0; i<n; i++){
        for(int j = 0; j<m; j++){
            if(a[i][j]==1){
                for(int k = j+1; k<m; k++){
                    if(a[i][k]==1){
                        if(mp.find(make_pair(j, k)) != mp.end()){
                            return true;
                        }
                        mp[make_pair(j, k)] = 1;
                    }
                }
            }
        }
    }
    return false;
}