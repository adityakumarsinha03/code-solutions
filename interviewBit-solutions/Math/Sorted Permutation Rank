/*

Given a string, find the rank of the string amongst its permutations sorted lexicographically. 
Assume that no characters are repeated.

Example :

Input : 'acb'
Output : 2

The order permutations with letters 'a', 'c', and 'b' : 
abc
acb
bac
bca
cab
cba
The answer might not fit in an integer, so return your answer % 1000003

*/

Solution:

/*long long perm(long long n){
    long long res = 1;
    for(long long i = 2; i<=n; i++){
        res = res*i;
    }
    return res;
}*/
int Solution::findRank(string s){
    
    long long n = s.length();
    if(n == 0){
        return 1;
    }
    if(n == 1){
        return 1;
    }
    
    long long ans = 0;
    for(long long i = 0; i<n; i++){
        int st = i;
        int x = 0;
        for(long long j = st+1; j<n; j++){
            if(s[i]>s[j]){
                x++;
            }
        }
        long long m = x;
        for(long long k = 2; k<=(n-i-1); k++){
            m = m*k;
            m = (m%1000003);
        }
        
        //m = m/(n-i);
        ans = ans + m;
        //ans+=(x*(m))%1000003;
    }
    int d = (ans+1)%1000003;
    return d;
}
