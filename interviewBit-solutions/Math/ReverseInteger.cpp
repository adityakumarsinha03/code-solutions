/*

Reverse digits of an integer.

Example1:

x = 123,

return 321
Example2:

x = -123,

return -321

Return 0 if the result overflows and does not fit in a 32 bit signed integer

*/

Solution:

int Solution::reverse(int n) {
    
    long long ans = 0;
    long long ima = 2147483647;
    //long long imn = −2147483647;
    if(n>ima){
        return 0;
    }
    int flag = 0;
    if(n<0){
        flag = 1;
    }
    long long m = (long long)abs(n);
    if(m>ima){
        return 0;
    }
    vector<long long>a;
    while(m>0){
        a.push_back(m%10);
        m = m/10;
    }
    if(a.size()>10){
        return 0;
    }
    for(int i = 0; i<a.size(); i++){
        ans = (ans*10)+(a[i]);
        if(ans>ima){
            return 0;
        }
    }
    if(flag == 1){
        ans = ans*(-1);
        //if(ans <imi){
        //    return 0;
        //}
    }
    int w = (int)ans;
    return w;
}
