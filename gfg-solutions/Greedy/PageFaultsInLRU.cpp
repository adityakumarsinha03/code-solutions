// https://practice.geeksforgeeks.org/problems/page-faults-in-lru/0

#include<bits/stdc++.h>
using namespace std;

int pageFaultsLRU(vector<int> vec, int capacity){
    unordered_set<int> st;
    unordered_map<int, int> mp;
    
    int pageFault = 0;
    for(int i = 0; i<vec.size(); i++){
        if(st.size() < capacity){
            if(st.find(vec[i]) == st.end()){
                st.insert(vec[i]);
                pageFault++;
            }
            mp[vec[i]] = i;
        } else{
            if(st.find(vec[i]) == st.end()){
                int lru = INT_MAX;
                int stVal;
                unordered_set<int> :: iterator it;
                for(it = st.begin(); it != st.end(); ++it){
                    if(mp[*it] < lru){
                        lru = mp[*it];
                        stVal = *it;
                    }
                }
                st.erase(stVal);
                st.insert(vec[i]);
                pageFault++;
            }
            mp[vec[i]] = i;
        }
    }
    return pageFault;
}
int main(){
	
	int t;
	cin >> t;
	while(t--){
	    int n;
	    cin >> n;
	    vector<int>a(n);
	    for(int i = 0; i<n; i++){
	        cin >> a[i];
	    }
	    int capacity;
	    cin >> capacity;
	    cout << pageFaultsLRU(a, capacity) << endl;
	}
	return 0;
}