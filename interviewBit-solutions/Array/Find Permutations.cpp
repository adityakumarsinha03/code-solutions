/*

Given a positive integer n and a string s consisting only of letters D or I, you have to 
find any permutation of first n positive integer that satisfy the given input string.

D means the next number is smaller, while I means the next number is greater.

Notes
- Length of given string s will always equal to n - 1
- Your solution should run in linear time and space.

Example :

Input 1:

n = 3

s = ID

Return: [1, 3, 2]

*/

Solution:

vector<int> Solution::findPerm(const string s, int n){
    vector<int>ans;
    vector<int>a(n);
    for(int i = 0; i<n; i++){
        a[i] = i+1;
    }
    int st = 0, en = n-1, state;
    if(s[0] == 'I'){
        ans.push_back(a[0]);
        st = 1;
        state = 0;
    }
    else if(s[0] == 'D'){
        ans.push_back(a[n-1]);
        en = n-2;
        state = 1;
    }
    int j = 0;
    while(s[j+1] != '\0'){
        if(s[j] != s[j+1]){
            if(state == 1){
                ans.push_back(a[st]);
                st++;
                state = 0;
            }
            else{
                ans.push_back(a[en]);
                en--;
                state = 1;
            }
        }
        else{
            if(state == 1){
                ans.push_back(a[en]);
                en--;
            }
            else if(state == 0){
                ans.push_back(a[st]);
                st++;
            }
        }
        j++;
    }
    ans.push_back(a[st]);
    return ans;
}
