/*

For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Output : 1

*/

Solution:

int Solution::colorful(int a){
    
    if(a<10){
        return 1;
    }
    map<int, int>m;
    int b = a;
    int y = 10;
    int e;
    int mul = 1;
    while(b >=y/10){
        while(b>=y/10){
            e = b%y;
            b = b/10;
            mul = 1;
            while(e>0){
                mul = mul*(e%10);
                e = e/10;
            }
            if(m.find(mul) == m.end()){
                m[mul] = 1;
            }
            else{
                return 0;
            }
        }
        y = y*10;
        b = a;
    }
    return 1;
}
