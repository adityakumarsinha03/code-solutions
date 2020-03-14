/*

Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Example:

Input : [1, 0]
Return : [0, 1]
 Lets say N = size of the array. Then, following holds true :
* All elements in the array are in the range [0, N-1]
* N * N does not overflow for a signed integer 

*/

Solution:

void Solution::arrange(vector<int> &a){
    
    int n = a.size();
    for(int i = 0; i<n; i++){
        a[i] = a[i] + ((a[a[i]]%n)*n);
    }
    for(int i = 0; i<n; i++){
        a[i] = a[i]/n; // for new value
        // a[i] = a[i]%n; for old value
    }    
}
