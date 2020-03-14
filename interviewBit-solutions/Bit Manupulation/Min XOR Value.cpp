/*

Given an array of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.

Examples : 
Input 
0 2 5 7 
Output 
2 (0 XOR 2) 
Input 
0 4 7 9 
Output 
3 (4 XOR 7)

Constraints: 
2 <= N <= 100 000 
0 <= A[i] <= 1 000 000 000

*/

Solution:

int Solution::findMinXor(vector<int> &a) {
    
    int n = a.size();
    long long ans = INT_MAX;
    sort(a.begin(), a.end());
    
    for(int i = 0; i<n-1; i++){
        int u = a[i];
        int v = a[i+1];
        int w = u^v;
        if(w < ans){
            ans = w;
        }
    }
    /*
    for(int i = 0; i<n-1; i++){
        int u = a[i];
        for(int j = i+1; j<n; j++){
            int v = a[j];
            int w = u^v;
            if(w < ans){
                ans = w;
            }
        }
    }*/
    return ans;
}
