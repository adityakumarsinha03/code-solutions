// https://practice.geeksforgeeks.org/problems/next-larger-element/0

#include<bits/stdc++.h>
using namespace std;

vector<long long> nextLargerElement(vector<long long>a){
    long long n = a.size();
    
    stack<long long> st;
    st.push(a[n-1]);
    
    vector<long long> ans(n);
    ans[n-1] = -1;
    for(long long i = n-2; i>=0; i--){
        while(!st.empty() && st.top()<=a[i]){
            st.pop();
        }
        if(st.empty()){
            ans[i] = -1;
        } else{
            ans[i] = st.top();
        }
        st.push(a[i]);
    }
    return ans;
}
int main(){
	
	int t;
	cin >> t;
	while(t--){
	    long long n;
	    cin >> n;
	    vector<long long>a(n);
	    for(long long i = 0; i<n; i++){
	        cin >> a[i];
	    }
	    
	    vector<long long>ans = nextLargerElement(a);
	    for(long long i = 0; i<n; i++){
	        cout << ans[i] << " ";
	    } cout << endl;
	}
	return 0;
}