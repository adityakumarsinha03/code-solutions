// https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3717/

class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        int width = 0;
        for(int i = 0; i<wall[0].size(); i++)
            width += wall[0][i];
        
        int sum = 0;
        map<int, int> mp;
        vector<int> v;
        for(int i = 0; i<wall.size(); i++){
            sum = 0;
            for(int j = 0; j<wall[i].size(); j++){
                sum += wall[i][j];
                mp[sum]++;
            }
        }
        map<int, int> :: iterator it;
        for(it = mp.begin(); it != mp.end(); ++it){
            v.push_back(it->second);
        }
        
        if(v.size() < 2)
            return wall.size();
        
        int maxEle = *max_element(v.begin(), v.end()-1);
        return wall.size()-maxEle;
    }
};