/*
You are given a read only array of n integers from 1 to n.
Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4

*/

Solution:

vector<int> Solution::repeatedNumber(const vector<int> &a) {

    long long n = a.size();
    long long q = n*(n+1)/2;
    long long s = n*(n+1)*((2*n)+1)/6;
    for(int i = 0; i<n; i++){
        q = q -(long long)a[i];
        s = s - ((long long)a[i]*(long long)a[i]);
    }
    
    long long x = (q+(s/q))/2;
    long long y = abs(q-x);
    
    int flag = 0;
    for(int i = 0; i<n; i++){
        if(x == a[i]){
            flag = 1;
            break;
        }
    }
    vector<int>d;    
    if(flag == 1){
        d.push_back(x);
        d.push_back(y);
    }
    else{
        d.push_back(y);
        d.push_back(x);
    }  
  return d;
}
