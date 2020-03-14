/*

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
There might be multiple gray code sequences possible for a given n.
Return any such sequence.

*/

Solution:

int pow1(int x, int y){
    int t = 1;
    for(int i = 0; i<y; i++){
        t = t*x;
    }
    return t;
}

void graycode(int n, vector<int>&ans, vector<int>&temp, int st){
    
    if(st>=n){
        int num = 0;
        for(int i = 0; i<n; i++){
            num = num + temp[i]*pow1(2, i);
        }
        ans.push_back(num);
        return;
    }
    graycode(n, ans, temp, st+1);
    temp[st] = temp[st]^1;
    graycode(n, ans, temp, st+1);
}

vector<int> Solution::grayCode(int n){
    
    vector<int>ans;
    vector<int>temp(n, 0);
    graycode(n, ans, temp, 0);
    return ans;
}
