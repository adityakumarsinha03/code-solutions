/*

Given a column title as appears in an Excel sheet, return its corresponding column number.

Example:

    A -> 1
    
    B -> 2
    
    C -> 3
    
    ...
    
    Z -> 26
    
    AA -> 27
    
    AB -> 28 

*/

Solution:

int Solution::titleToNumber(string a) {
    
    int n = 0;
    int m = a.length();
    int i = 0;
    while(a[i] != '\0'){
        int x = (int)a[i] - 64;
        int y = 1;
        for(int j = 0; j<m-i-1; j++){
            y = y*26;
        }
        n = n+(x*y);
        i++;
    }
    return n;
}
