// https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3718/

class Solution {
public:
    int countBinarySubstrings(string s) {
        int len = s.length();
        
        int ans = 0;
        vector<pair<int, int> > v;
        
        int count0 = 0;
        int count1 = 0;
        int m = 0;
        while(m<len){
            count0 = 0;
            count1 = 0;
            while(m<len && s[m] == '0'){
                count0++;
                m++;
            }
            while(m<len && s[m] == '1'){
                count1++;
                m++;
            }
            if(count0 != 0){
                v.push_back(make_pair(0, count0));
            }
            if(count1 != 0){
                v.push_back(make_pair(1, count1));
            }
        }
        
        for(int i = 0; i+1<v.size(); i++){
            ans += min(v[i].second, v[i+1].second);
        }
        return ans;
    }
};