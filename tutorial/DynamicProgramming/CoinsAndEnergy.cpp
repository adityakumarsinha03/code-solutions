#include<bits/stdc++.h>
using namespace std;

int func(vector<int> coins, vector<int> energy, int e, int i, int n, vector<vector<int> >&dp){
    if(i == n || e < 0)
        return 0;
    
    if(e<n && dp[i][e] != -1)
        return dp[i][e];
    
    int choice1 = 0;
    
    // Take the coin
    if(e > 0)
        choice1 = coins[i]+func(coins, energy, e-1, i+1, n, dp);
    
    // Take the energy to move ahead or take that coin and stay there
    int choice2 = max(func(coins, energy, min(n, e+energy[i]), i+1, n, dp), coins[i]);
    
    return dp[i][e] = max(choice1, choice2);
}

int main(){
    int n = 3;
    
    vector<int> coins{11, 5, 7};
    vector<int> energy{2, 1, 1};
    
    int initialEnergy = 1;
    
    vector<vector<int> > dp(n, vector<int>(n, -1));
    int ans = func(coins, energy, initialEnergy, 0, n, dp);
    cout << ans << endl;
    
    return 0;
}
