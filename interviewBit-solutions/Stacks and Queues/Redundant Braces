/*

Write a program to validate if the input string has redundant braces?
Return 0/1 
0 -> NO 1 -> YES 

Input will be always a valid expression

and operators allowed are only + , * , - , /

Example:

((a + b)) has redundant braces so answer will be 1
(a + (a + b)) doesn't have have any redundant braces so answer will be 0

*/

Solution:

int Solution::braces(string a){
    
    stack<int>s;
    int i = 0;
    while(a[i] != '\0'){
        if(a[i] == '('){
            s.push(1);
        }
        else if((a[i] == '+' || a[i] == '-' || a[i] == '*' || a[i] == '/') && !s.empty() && s.top()!=0){
            s.push(0);
        }
        else if(a[i] == ')'){
            if(!s.empty() && s.top() == 0){
                s.pop();
                s.pop();
            }
            else{
                return 1;
            }
        }
        i++;
    }
    return 0;
}
