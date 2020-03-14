/*

Implement int sqrt(int x).

Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x))

Example :

Input : 11
Output : 3
DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY

*/

Solution:

int Solution::sqrt(int n){
    
    if(n<=1){
        return n;
    }
    long long low = 0;
    long long high = n;
    long long mid;
    while(low<=high){
        mid = (low+high)/2;
        if(mid*mid > n){
            high = mid-1;
        }
        else if(mid*mid < n){
            low = mid+1;
        }
        else{
            return (int)mid;
        }
    }
    return (int)(low+high)/2;
}
