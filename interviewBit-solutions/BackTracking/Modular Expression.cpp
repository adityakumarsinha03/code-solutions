/*

Implement pow(A, B) % C.

In other words, given A, B and C, 
find (AB)%C.

Input : A = 2, B = 3, C = 3
Return : 2 
2^3 % 3 = 8 % 3 = 2

*/

Solution:

int powmodn(long long x, long long n, long long d){
    if(x<0){
        x = x+d;
    }
    if(n == 0){
        return 1;
    }
    else if(n%2 == 0){
        long long y = powmodn(x, n/2, d);
        return (y*y)%d;
    }
    else{
        return ((x%d)*powmodn(x, n-1, d))%d;
    }
}

int Solution::Mod(int x, int n, int d){
    if(x == 0){
        return 0;
    }
    return powmodn(x, n, d);
}
