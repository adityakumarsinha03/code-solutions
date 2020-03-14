/*

You are given two positive numbers A and B. You need to find the maximum valued integer X such that:

X divides A i.e. A % X = 0
X and B are co-prime i.e. gcd(X, B) = 1
For example,

A = 30
B = 12
We return
X = 5

*/

Solution:

int Solution::cpFact(int a, int b){
    
    while(__gcd(a, b) != 1){
        a = a/(__gcd(a, b));
    }
    return a;
    /*if(__gcd(a, b) == 1){
        return a;
    }*/
    /*
    for(int i = a-1; i>=2; i--){
        if(a%i==0 && b%i != 0 && i%b!=0){
            if(__gcd(i, b) == 1){
                return i;
            }
        }
    }
    */
    /*int p = a;
    for(int i = 2; i<= a/2 && i<=b/2; i++){
        if(b%i == 0 && a%i==0 && p%i==0){
            p = p/i;
            cout << "p= " << p << endl;
        }
    }
    for(int i = p; i>=2; i--){
        if(p%i==0 && b%i!=0 && i%b!=0){
            if(__gcd(i, b) == 1){
                return i;
            }
        }
    }
    return 1;
    */
}
