/*

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Example :

n = 5
n! = 120 
Number of trailing zeros = 1
So, return 1

*/

Solution:

int Solution::trailingZeroes(int n) {
    
    int ans = 0;
    int z = 5;
    int y = n/z;
    ans = ans + y;
    while(y>0){
        z = z*5;
        y = n/z;
        ans = ans+y;
    }
    return ans;
}
