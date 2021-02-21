// https://practice.geeksforgeeks.org/problems/josephus-problem/1
#include <bits/stdc++.h>
using namespace std;

class Solution
{
    public:
    void josephusUtil(vector<int> vec, int k, int index, int &ans){
        if(vec.size() == 1){
            ans = vec[0];
            return;
        }
        
        index = (index + k)%(vec.size());
        vec.erase(vec.begin()+index); // person killed removed from array
        
        josephusUtil(vec, k, index, ans);
    }
    int josephus(int n, int k)
    {
        int ans = -1;
        vector<int> vec(n); // array of person with numbers
        for(int i = 0; i<n; i++){
            vec[i] = i+1;
        }

        k--; // since we count k including the person too
        josephusUtil(vec, k, 0, ans);
        return ans;
    }
};
