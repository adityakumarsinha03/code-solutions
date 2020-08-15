// https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string/0

#include<bits/stdc++.h>
using namespace std;

void solve(string A,string B){
    int missing=B.length();
    map<char, int> mpA;
    map<char, int> mpB;
    for(int i=0; i<B.length(); i++){
        mpB[B[i]]++;
    }
    int l = 0, r = 0;
    int left = 0, right = A.length();
    
    int flag = 0;
    while(r<A.length()){
        mpA[A[r]]++;
        if(mpB.find(A[r])!=mpB.end() && mpA[A[r]]<=mpB[A[r]])
            missing--;
        
        while(missing==0 && l<=r){
            flag = 1;
            if(r-l < right-left){
                left = l;
                right = r;
            }
            if(mpB.find(A[l])!=mpB.end() && mpA[A[l]]<=mpB[A[l]])
                missing++;
                
            mpA[A[l]]--;
            l++;
        }
        r++;
    }
    if(flag == 0)
        cout << -1 << endl;
    else
        cout<<A.substr(left, right-left+1)<<endl;
    return;
}
int main(){
	int t;
	cin>>t;
	while(t--){
	    string A, b;
	    cin >> A >>  b;
	    solve(A,b);
	}
	return 0;
}