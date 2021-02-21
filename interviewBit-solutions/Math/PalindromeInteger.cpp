/*

Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False

*/

Solution:

bool Solution::isPalindrome(int n) {
    
    vector<int>a;
    if(n<0){
        return false;
    }
    if(n < 10){
        return true;
    }
    while(n > 0){
        a.push_back(n%10);
        n = n/10;
    }
    for(int i = 0; i<a.size()/2; i++){
        if(a[i] != a[a.size()-1-i]){
            return false;
        }
    }
    return true;
    
    // Another method:
    // for i = 1 to length of number(len):
    //     u = ((n%(pow(10, i)))/pow(10, i-1))
    //     v = (n/pow(10, len-i))%(pow(10, i-1))
    //     if u != v
    //         break;
    //     end
    // end
}
