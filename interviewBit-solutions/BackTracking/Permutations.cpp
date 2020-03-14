/*

Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3] 
[2,3,1] 
[3,1,2] 
[3,2,1]

*/

Solution:

void swap(int *a, int *b){
    
    int temp;
    temp = *a;
    *a = *b;
    *b = temp;
}

void perm(vector<int>&a, int l, int r, vector<vector<int> >&s){
    
    if(l == r){
        s.push_back(a);
    }
    for(int i = l; i<=r; i++){
        swap(&a[i], &a[l]);
        perm(a, l+1, r, s);
        swap(&a[i], &a[l]);
    }
}

vector<vector<int> > Solution::permute(vector<int> &a){
    
    vector<vector<int> >s;
    int n = a.size();
    perm(a, 0, n-1, s);
    return s;
}
