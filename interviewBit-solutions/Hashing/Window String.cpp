/*

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.

Example :

S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC"

 Note:
If there is no such window in S that covers all characters in T, return the empty string ''.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).

*/

Solution:

string Solution::minWindow(string s, string t){
    
    int lens = s.length();
    int lent = t.length();
    string ans = "";
    if(lens==0 || lent==0){
        return ans;
    }
    if(lent>lens){
        return ans;
    }
    if(lent==1 && lens==1){
        if(s[0]!=t[0]){
            return ans;
        }
        else{
            ans = ans+s;
            return ans;
        }
    }
    map<char, int>pat;
    map<char, int>str;
    for(int i = 0; i<lent; i++){
        if(pat.find(t[i]) == pat.end()){
            pat[t[i]] = 1;
        }
        else{
            pat[t[i]]++;
        }
    }
    
    int st = 0, st_ind = -1, min_len = INT_MAX;
    int count1 = 0;
    for(int j = 0; j<lens; j++){
        if(str.find(s[j]) == str.end()){
            str[s[j]] = 1;
        }
        else{
            str[s[j]]++;
        }
        
        if((pat.find(s[j])!=pat.end() || pat[s[j]]!=0) && (str[s[j]] <= pat[s[j]])){
            count1++;
        }
        if(count1 == lent){
            while((str[s[st]] > pat[s[st]]) || (pat.find(s[st])==pat.end() ||pat[s[st]]==0)){
                if(str[s[st]] > pat[s[st]]){
                    str[s[st]]--;
                }
                st++;
            }
            int l = j-st+1;
            if(l<min_len){
                min_len = l;
                st_ind = st;
            }
        }
    }
    if(st_ind == -1){
        return ans;
    }
    ans = s.substr(st_ind, min_len);
    return ans;
}
