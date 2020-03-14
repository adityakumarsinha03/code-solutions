/*

Given a collection of integers that might contain duplicates, S, return all possible subsets.

 Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.
Example :
If S = [1,2,2], the solution is:

[
[],
[1],
[1,2],
[1,2,2],
[2],
[2, 2]
]

*/

Solution:

void subsetUtil(vector<int>&a, vector<vector<int> >&ans, vector<int>&d, int st, int en, map<vector<int>, int>&m){
    
    if(m.find(d) == m.end()){
        m[d]++;
        ans.push_back(d);
    }
    /*if(ans.size() == 0){
        ans.push_back(d);
    }
    else{
        vector<int>y = ans[ans.size()-1];
        if(y.size() != d.size()){
            ans.push_back(d);
        }
        else{
            int flag = 0;
            for(int j = 0; j<y.size(); j++){
                if(y[j] != d[j]){
                    flag = 1;
                    break;
                }    
            }
            if(flag == 1){
                ans.push_back(d);
            }
            else{
                return;
            }
        }
    }*/
    if(st>en){
        return;
    }
    for(int i = st; i<=en; i++){
        d.push_back(a[i]);
        subsetUtil(a, ans, d, i+1, en, m);
        d.pop_back();
    }
}

vector<vector<int> > Solution::subsetsWithDup(vector<int> &a){
    
    int n = a.size();
    sort(a.begin(), a.end());
    
    map<vector<int>, int>m;
    vector<int>d;
    vector<vector<int> >ans;
    subsetUtil(a, ans, d, 0, n-1, m);
    // ans.erase(unique(ans.begin(), ans.end()), ans.end());
    return ans;
}
