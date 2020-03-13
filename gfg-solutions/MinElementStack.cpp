// https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1

/*
The structure of the class is as follows
class _stack{
stack<int> s;
int minEle;
public :
    int getMin();
    int pop();
    void push(int);
};
*/

/*returns min element from stack*/
int _stack :: getMin()
{
   if(!s.empty()){
        return s.top();
    }
    return -1;
}

/*returns poped element from stack*/
int _stack ::pop()
{
    if(s.empty())
        return -1;
    s.pop();
    int ans = s.top();
    s.pop();
    
    if(!s.empty())
        minEle = s.top();
        
    return ans;
}

/*push element x into the stack*/
void _stack::push(int x)
{
   if(s.empty())
        minEle = INT_MAX;
   if(x<minEle)
        minEle = x;
        
   s.push(x);
   s.push(minEle);
}