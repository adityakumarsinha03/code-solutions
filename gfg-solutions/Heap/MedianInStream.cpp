// https://practice.geeksforgeeks.org/problems/find-median-in-a-stream/0

#include<bits/stdc++.h>
using namespace std;
int main(){
	
    int n;
    cin >> n;
    
    // Heaps to keep track of middle element
    // The way we sort the stream, the same way, we try to
    // put left part of sorted array into MaxHeap, and right in MinHeap.
    // This will always keep the track of middle elements required for median.
    priority_queue<double> pqMax;
    priority_queue<double, vector<double>, greater<double> > pqMin;
    
    double x;
    cin >> x;
    pqMax.push(x);
    
    double med = x;
    cout << med << endl;
    
    for(int i = 1; i<n; i++){
        cin >> x;
        
        if(pqMin.size() < pqMax.size()){
            if(x < med){
                pqMin.push(pqMax.top());
                pqMax.pop();
                pqMax.push(x);
            } else{
                pqMin.push(x);
            }
            med = (pqMin.top() + pqMax.top())/2.0;
        }
        else if(pqMin.size() > pqMax.size()){
            if(x > med){
                pqMax.push(pqMin.top());
                pqMin.pop();
                pqMin.push(x);
            } else{
                pqMax.push(x);
            }
            med = (pqMin.top() + pqMax.top())/2.0;
        }
        else{
            if(x < med){
                pqMax.push(x);
                med = (double)pqMax.top();
            } else{
                pqMin.push(x);
                med = (double)pqMin.top();
            }
        }
        cout << (int)med << endl;
    }
	return 0;
}