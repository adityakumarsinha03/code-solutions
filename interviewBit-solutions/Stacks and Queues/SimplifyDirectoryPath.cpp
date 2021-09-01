/*

Given an absolute path for a file (Unix-style), simplify it.

Examples:

path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
Note that absolute path always begin with ‘/’ ( root directory )
Path will not have whitespace characters.

*/

Solution:

string Solution::simplifyPath(string a){
    
    deque<string>q;
    int n = a.length();
    int i = 0;
    string t = "";
    while(a[i] != '\0'){
        if(a[i] == '.' && a[i+1] == '.'){
            if(!q.empty()){
                q.pop_back();
            }
            i = i+1;
        }
        else if(a[i] == '/' && t.length() != 0){
            // cout << "t= " << t << endl;
            q.push_back(t);
            t = "";
        }
        else if(a[i]!='.' && a[i] != '/'){
            t = t+a[i];
        }
        i++;
    }
    if(t.length() != 0){
        q.push_back(t);
        t = "";
    }
    string ans = "";
    while(!q.empty()){
        ans = ans+"/";
        string u = q.front();
        q.pop_front();
        ans = ans + u;
    }
    if(ans.size() == 0){
        ans = ans+"/";
    }
    return ans;
}
