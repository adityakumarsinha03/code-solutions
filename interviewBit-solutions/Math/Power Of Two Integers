/*

Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P 
where P > 1 and A > 0. A and P both should be integers.

Example

Input : 4
Output : True  
as 2^2 = 4. 

*/

Solution:

int ch(int n, int x){
    
    while(n>1){
        if(n%x == 0){
            n = n/x;
        }
        else{
            return 0;
        }
    }
    return 1;
}

bool Solution::isPower(int n) {
    
    // 0 case
    if(n == 1){
        return true;
    }
    else if(n<4){
        return false;
    }
    
   // vector<int>a;
    int m = n;
    for(int i = 2; i<=sqrt(m); i++){
        if(m%i == 0){
            //a.push_back(i);
            //a.push_back(m/i);
            if(ch(n, i) == 1 || ch(n, m/i) == 1){
                return true;
            }
        }
    }
    return false;
    
    // Another method:
    // start from p = 2 and break the while loop when 2^p > x.
    // and inside while loop, iterate from i = 2 to i^p<=x, break 
    // the for loop when i^p == x
}
