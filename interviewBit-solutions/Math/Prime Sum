/*

Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d] 

If a < c OR a==c AND b < d. 

*/

Solution:

int ch(int x){
    if(x < 2){
        return 0;
    }
    else if(x==2 ||x==3){
        return 1;
    }
    for(int i = 2; i<=sqrt(x); i++){
        if(x%i==0){
            return 0;
        }
    }
    return 1;
}

vector<int> Solution::primesum(int n) {
    
    vector<int>a;
    for(int i = 2; i<=(n/2); i++){
        if(ch(i) == 1){
            if(ch(n-i) == 1){
                a.push_back(i);
                a.push_back(n-i);
                break;
            }
        }
    }
    return a;
}
