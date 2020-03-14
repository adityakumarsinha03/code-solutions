/*

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

*/

Solution:

// Using stack, this problem becomes much easy

int Solution::longestValidParentheses(string s){
    
    int n = s.length();
	    stack<int>st;
	    st.push(-1);
	    int ans = 0;
	    int j = 0;
	    while(s[j] != '\0'){
	        if(s[j] == '('){
	            st.push(j);
	        }
	        else{
	            st.pop();
	            if(!st.empty()){
	                ans = max(ans, j-st.top());
	            }
	            else{
	                st.push(j);
	            }
	        }
	        j++;
	    }
	    return ans;
}
