// https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3695/

class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        
        int res = 0;
        
        for(int i = 0; i<n; i++){
            if(s.charAt(i) == '('){
                st.push(i);
            } else{
                if(!st.isEmpty())
                    st.pop();
                if(!st.isEmpty()){
                    int temp = i - st.peek();
                    res = Math.max(temp, res);
                } else
                    st.push(i);
            }
        }
        return res;
    }
}