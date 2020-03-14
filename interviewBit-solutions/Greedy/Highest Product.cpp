/*

Given an array of integers, return the highest product possible by multiplying 3 numbers from the array

Input:

array of integers e.g {1, 2, 3}
NOTE: Solution will fit in a 32-bit signed integer 
Example:

[0, -1, 3, 100, 70, 50]

=> 70*50*100 = 350000

*/

Solution:

int Solution::maxp3(vector<int> &a){
    
    int n = a.size();
    sort(a.begin(), a.end());
    int b = a[n-1]*a[n-2]*a[n-3];
    int c = a[0]*a[1]*a[2];
    int d = a[0]*a[1]*a[n-1];
    int e = a[n-1]*a[n-2]*a[0];
    
    return max(b, max(c, max(d,e)));
}
