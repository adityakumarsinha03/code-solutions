/*

Given a set of distinct integers, S, return all possible subsets.

 Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
Example :

If S = [1,2,3], a solution is:

[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]

*/

Solution:

void subsetUtil(vector<int>a, int st, int en, vector<vector<int> >&ans, vector<int>&d){
    
    ans.push_back(d);
    if(st>en){
        return;
    }
    for(int i = st; i<=en; i++){
        d.push_back(a[i]);
        subsetUtil(a, i+1, en, ans, d);
        d.pop_back();
    }
}

vector<vector<int> > Solution::subsets(vector<int> &a){
    
    int n = a.size();
    vector<vector<int> >ans;
    vector<int>d;
    if(n == 0){
        ans.push_back(d);
        return ans;
    }
    sort(a.begin(), a.end());
    subsetUtil(a, 0, n-1, ans, d);
    return ans;
}
