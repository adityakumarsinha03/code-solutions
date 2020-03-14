/*

Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,
1. Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
2. Entries should be sorted within themselves.

Example :
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]

*/

Solution:

void combineUtil(vector<int>&a, int st, int en, vector<vector<int> >&ans, vector<int>&d, int k){
    
    if(d.size() == k){
        ans.push_back(d);
        return;
    }
    if(st>en){
        return;
    }
    for(int i = st; i<=en; i++){
        d.push_back(a[i]);
        combineUtil(a, i+1, en, ans, d, k);
        d.pop_back();
    }
}

vector<vector<int> > Solution::combine(int n, int k){
    
    vector<int>a(n);
    for(int i = 0; i<n; i++){
        a[i] = i+1;
    }
    vector<vector<int> >ans;
    vector<int>d;
    if(n < k){
        return ans;
    }
    combineUtil(a, 0, n-1, ans, d, k);
    return ans;
}
