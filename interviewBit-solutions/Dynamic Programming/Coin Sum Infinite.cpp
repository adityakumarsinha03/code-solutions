/*

You are given a set of coins S. In how many ways can you make sum N assuming you have infinite amount of each coin in the set.

Note : Coins in set S will be unique. Expected space complexity of this problem is O(N).

Example :

Input : 
	S = [1, 2, 3] 
	N = 4

Return : 4

Explanation : The 4 possible ways are
{1, 1, 1, 1}
{1, 1, 2}
{2, 2}
{1, 3}	
Note that the answer can overflow. So, give us the answer % 1000007

*/

Solution:

int Solution::coinchange2(vector<int> &a, int s) {
    
    int n = a.size();
    if(s == 0 || n == 0){
        return 0;
    }
    if(n == 1 && s%a[0] != 0){
        return 0;
    }
    else if(n == 1 && s%a[0] == 0){
        return 1;
    }
    sort(a.begin(), a.end());
    if(s<a[0]){
        return 0;
    }
    vector<vector<long long> >t(2, vector<long long>(s+1, 1));
    
    t[0][0] = 1;
    for(int i = 1; i<=s; i++){
        if(i%a[0] == 0){
            t[0][i] = 1;
        }
        else{
            t[0][i] = 0;
        }
    }
    long long b = (1000*1000)+7;
    for(int j = 1; j<a.size(); j++){
        for(int i = 1; i<=s; i++){
            if(i>=a[j]){
                t[1][i] = ((t[0][i])%b + (t[1][i-a[j]])%b)%b;
            }
            else{
                t[1][i] = t[0][i];
            }
        }
        for(int k = 1; k<=s; k++){
            t[0][k] = t[1][k];
        }
    }
    return (t[0][s])%b;
}
