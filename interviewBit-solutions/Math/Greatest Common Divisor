/*

Given 2 non negative integers m and n, find gcd(m, n)

GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
Both m and n fit in a 32 bit signed integer.

Example

m : 6
n : 9

GCD(m, n) : 3 

*/

Solution:

int Solution::gcd(int a, int b){
    
    if(a == 0 && b == 0){
        return 0;
    }
    else if(a == 0 || b == 0){
        return (a == 0) ? b : a;
    }
    else if(a == 1 || b == 1){
        return (a == 1) ? b : a;
    }
    int dnd, dsr;
    if(a>b){
        dnd = a;
        dsr = b;
    }
    else{
        dnd = b;
        dsr = a;
    }
    int p = dsr;
    while(p != 0){
        p = dnd%dsr;
        dnd = dsr;
        dsr = p;
    }
    return dnd;
}
