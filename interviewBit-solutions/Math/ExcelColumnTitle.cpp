/*

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 

*/

Solution:

string Solution::convertToTitle(int n) {
    
    string s = "";
    while(n>0){
        if(n%26 == 0){
            s = 'Z' + s;
            if(n == 26){
                n = 0;
            }
            n = n-1;
        }
        else{
            s = (char)((n%26) +64) +s;
        }
        n = n/26;
    }
    
    return s;
}
