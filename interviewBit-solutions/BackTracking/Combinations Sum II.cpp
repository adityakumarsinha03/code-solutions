/*

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

 Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example :

Given candidate set 10,1,2,7,6,1,5 and target 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]

*/

Solution:

void combUtil(vector<int>&a, vector<vector<int> >&ans, vector<int>&d, int st, int en, int k, int &sum){
    
    int n = a.size();
    if(sum == k){
        ans.push_back(d);
        return;
    }
    if(sum>k){
        return;
    }
    if(st>en){
        return;
    }
    for(int i = st; i<=en; i++){
        d.push_back(a[i]);
        sum+=a[i];
        combUtil(a, ans, d, i+1, en, k, sum);
        sum-=a[i];
        d.pop_back();
    }
}

vector<vector<int> > Solution::combinationSum(vector<int> &a, int k){
    
    int n = a.size();
    sort(a.begin(), a.end());
    vector<vector<int> >ans;
    vector<int>d;
    if(n < 0){
        return ans;
    }
    int sum = 0;
    combUtil(a, ans, d, 0, n-1, k, sum);
    ans.erase(unique(ans.begin(), ans.end()), ans.end());
    return ans;
}
