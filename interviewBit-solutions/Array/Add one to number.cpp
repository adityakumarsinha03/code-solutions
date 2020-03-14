/*
Given a non-negative number represented as an array of digits,
add 1 to the number ( increment the number represented by the digits ).
The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3], the returned vector should be [1, 2, 4]
as 123 + 1 = 124.

*/

Solution:

vector<int> Solution::plusOne(vector<int> &a) {
    
    vector<int>b;
    
    int n = a.size();
    int x = 0;
    b.push_back((a[n-1]+1)%10);
    x = (a[n-1]+1)/10;
    for(int i = n-2; i>=0; i--){
        if(x==0){
            b.push_back((a[i])%10);
        }
        else{
            b.push_back((a[i]+1)%10);
            x = (a[i]+1)/10;
        }
    }
    if(x == 1){
        b.push_back(1);
    }
    reverse(b.begin(), b.end());
    while(b[0] == 0){
        b.erase(b.begin());
    }
    return b;
}
