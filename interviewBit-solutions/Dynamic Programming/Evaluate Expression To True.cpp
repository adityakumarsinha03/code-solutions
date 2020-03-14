/*

Given expression with operands and operators (OR , AND , XOR) , in how many ways can you evaluate the expression to true, 
by grouping in different ways? Operands are only true and false.
Input:
 string : T|F&T^T here '|' will represent or operator '&' will represent and operator '^' will represent xor operator 
 'T' will represent true operand 'F' will false 

Output:
 different ways % MOD where MOD = 1003 

Example:
 string : T|F only 1 way (T|F) => T so output will be 1 % MOD = 1 

*/

Solution:

int Solution::cnttrue(string s){
    
    int n = s.length();
    string u = "";
    string v = "";
    for(int i = 0; i<n; i++){
        if(s[i] == 'T' || s[i] == 'F'){
            u = u+s[i];
        }
        else{
            v = v+s[i];
        }
    }
    int len = u.length();
    int T[len][len];
    int F[len][len];
    for(int i = 0; i<len; i++){
        if(u[i] == 'T'){
            T[i][i] = 1;
            F[i][i] = 0;
        }
        else{
            T[i][i] = 0;
            F[i][i] = 1;
        }
    }
    for(int dist = 1; dist<n; dist++){
        for(int i = 0, j = dist; j<len; i++, j++){
            T[i][j] = 0;
            F[i][j] = 0;
            for(int g = 0; g<dist; g++){
                int k = i+g;
                int tik = T[i][k] + F[i][k];
                int tkj = T[k+1][j] + F[k+1][j];
                if(v[k] == '&'){
                    T[i][j] = ((T[i][j])%1003 + (T[i][k]*T[k+1][j])%1003);
                    F[i][j] = ((F[i][j])%1003 + (tik*tkj - T[i][k]*T[k+1][j])%1003);
                }
                else if(v[k] == '|'){
                    T[i][j] = ((T[i][j])%1003 + (tik*tkj - F[i][k]*F[k+1][j])%1003);
                    F[i][j] = ((F[i][j])%1003 + (F[i][k]*F[k+1][j])%1003)%1003;
                }
                else if(v[k] == '^'){
                    T[i][j] = ((T[i][j])%1003 + (T[i][k]*F[k+1][j] + F[i][k]*T[k+1][j])%1003)%1003;
                    F[i][j] = ((F[i][j])%1003 + (T[i][k]*T[k+1][j] + F[i][k]*F[k+1][j])%1003)%1003;
                }
            }
        }
    }
    return T[0][len-1]%1003;   
}
