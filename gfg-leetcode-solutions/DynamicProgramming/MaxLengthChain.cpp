// https://practice.geeksforgeeks.org/problems/max-length-chain/1

/*
The structure to use is as follows
struct val{
	int first;
	int second;
};*/

/*You are required to complete this method*/
bool compare(pair<int, int> p1, pair<int, int> p2){ 
    return (p1.second < p2.second); 
} 
int maxChainLen(struct val p[],int n){
    vector<pair<int, int> > a(n);
    for(int i = 0; i<n; i++){
        a[i] = make_pair(p[i].first, p[i].second);
    }
    
    sort(a.begin(), a.end(), compare);
    
    vector<int> dp(n, 1);
    int last = a[0].second;
    for(int i = 1; i<n; i++){
        if(a[i].first > last){
            last = a[i].second;
            dp[i] = dp[i-1] + 1;
        } else{
            dp[i] = dp[i-1];
        }
    }
    return dp[n-1];
}