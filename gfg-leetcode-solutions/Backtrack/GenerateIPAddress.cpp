// https://practice.geeksforgeeks.org/problems/generate-ip-addresses/1#

#include <bits/stdc++.h>
using namespace std;

class Solution{
  public:
    int check(string s){
        if(s.length() <1 || s.length() > 3)
            return 0;
        int temp = stoi(s);
        if(temp > 255 || s!=to_string(temp))
            return 0;
        return 1;
    }
    void checkUtil(string s, vector<string> &ans, string s1, string s2, string s3, string s4){
        if(check(s1)==1 && check(s2)==1 && check(s3)==1 && check(s4)==1){
            ans.push_back(s1 + "." + s2 + "." + s3 + "." + s4);
            return;
        }
    }
    void genIpUtil(string s, vector<string> &ans){
        for(int b = 1; b<=3; b++){
            for(int c = 1; c<=3; c++){
                for(int d = 1; d<=3; d++){
                    string temp1 = s.substr(0, d);
                    string temp2 = "";
                    string temp3 = "";
                    string temp4 = "";
                    if(d<s.length())
                        temp2 = s.substr(d, c);
                    if(d+c<s.length())
                        temp3 = s.substr(d+c, b);
                    if(d+c+b<s.length())
                        temp4 = s.substr(d+c+b, -1);
                    checkUtil(s, ans, temp1, temp2, temp3, temp4);
                }
            }
        }
    }
    vector<string> genIp(string &s) {
        int len = s.length();   
        vector<string> ans;
        
        genIpUtil(s, ans);
        return ans;
    }
};

int main() {
    int T;
    cin >> T;
    while (T--) {
        string s;
        cin >> s;

        Solution obj;
        vector<string> str = obj.genIp(s);
        sort(str.begin(), str.end());
        for (auto &u : str) {
            cout << u << "\n";
        }
    }
}
