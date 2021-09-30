#include<bits/stdc++.h>
using namespace std;


vector<string>solve(int n){
    if(n==0){
        vector<string>temp;
        temp.push_back("");
        return temp;
    }
    if(n<0){
        vector<string>temp;
        return temp;
    }
    
    vector<string>A=solve(n-1);
    
    vector<string>B=solve(n-2);
    
    vector<string>C=solve(n-3);
    
    vector<string>ans;
    
    for(int i=0;i<A.size();i++){
        ans.push_back("1"+ A[i]);
    }
    
    for(int i=0;i<B.size();i++){
        ans.push_back("2"+ B[i]);
    }
    
    for(int i=0;i<C.size();i++){
        ans.push_back("3"+ C[i]);
    }
    
    return ans;
}

int main(){
    int n;
    cin>>n;
    vector<string>ans=solve(n);
    
    for(int i=0;i<ans.size();i++){
        cout<<ans[i]<<" ";
    }
    
    return 0;
}
