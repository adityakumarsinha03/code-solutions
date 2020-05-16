// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/

class Solution {
    public String removeKdigits(String num, int k) {
        int pop = 0;
        
        Stack<String> st = new Stack<String>();
        for(int i = 0; i<num.length(); i++){
            String temp = num.substring(i, i+1);
            // System.out.println("temp= " + temp);
            if(st.empty() == true)
                st.push(temp);
            else{
                String c = st.peek();
                if(pop < k && c.compareTo(temp) > 0){
                    while(st.empty() == false && pop < k && st.peek().compareTo(temp) > 0){
                        st.pop();
                        pop++;
                    }
                    st.push(temp);
                } else{
                    st.push(temp);
                }
            }
        }
        while(st.empty() == false && pop < k){
            st.pop();
            pop++;
        }
        String s = new String();
        while(st.empty() == false){
            s = st.peek() + s;
            st.pop();
        }
        int ind = 0;
        for(ind= 0; ind<s.length(); ind++){
            if(s.charAt(ind) != '0')
                break;
        }
        String ans = s.substring(ind);
        if(ans.length() == 0)
            ans = "0";
        return ans;
    }
}