class LetterCombinationOfPhoneNumber {
public:
    void letterCombinationsUtil(string digits, int x, map<string, string> mp, string temp, vector<string> &ans){
        if(temp.length()>0 && temp.length() == digits.length()){
            ans.push_back(temp);
            return;
        }
        for(int i = x; i<digits.length(); i++){
            string t1 = to_string(digits[i]-'0');
            for(int j = 0; j<mp[t1].length(); j++){
                temp.push_back(mp[t1][j]);
                letterCombinationsUtil(digits, i+1, mp, temp, ans);
                temp.pop_back();
            }
        }
    }
    vector<string> letterCombinations(string digits) {
        map<string, string> mp;
        mp["2"] = "abc";
        mp["3"] = "def";
        mp["4"] = "ghi";
        mp["5"] = "jkl";
        mp["6"] = "mno";
        mp["7"] = "pqrs";
        mp["8"] = "tuv";
        mp["9"] = "wxyz";
        
        vector<string> ans;
        letterCombinationsUtil(digits, 0, mp, "", ans);
        return ans;
    }
};