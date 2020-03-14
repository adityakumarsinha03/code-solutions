/*

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

The digit 0 maps to 0 itself.
The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Make sure the returned strings are lexicographically sorted.

*/

Solution:

void phnum(vector<string>&ans, vector<char>&num, map<char, string>&m, int st, string temp){
    // Base case 
    if(temp.length() == num.size()){
        ans.push_back(temp);
        return;
    }
    for(int i = 0; i<m[num[st]].length(); i++){
        temp += m[num[st]][i];
        phnum(ans, num, m, st+1, temp);
        temp.pop_back();
    }
}

/*void phnum(vector<string>&ans, vector<char>&num, int n, map<char, string>&m, string s, vector<int>&d, int k, int &count1){
    // Base case 
    if(count1 > k){
        return;
    }
    count1++;
    ans.push_back(s);
    // cout << count1 << " ";
    // cout << s << "\n";
    
    for(int i = 0; i<d.size(); i++){
        s[i] = m[num[i]][d[i]];
    }
    for(int j = 0; j<d.size(); j++){
        if(d[n-j-1] < m[num[n-j-1]].length()-1){
            d[n-j-1]++;
            phnum(ans, num, n, m, s, d, k, count1);
        }
        d[n-j-1]=0;
    }
}
*/

vector<string> Solution::letterCombinations(string f){
    
    vector<string>ans;
    int n = f.length();
    //sort(f.begin(), f.end());
	vector<char>num(n);
	for(int i = 0; i<n; i++){
	    num[i] = f[i];
	}
	map<char, string>m;
	m['0'] = "0";
	m['1'] = "1";
	m['2'] = "abc";
	m['3'] = "def";
	m['4'] = "ghi";
	m['5'] = "jkl";
	m['6'] = "mno";
	m['7'] = "pqrs";
	m['8'] = "tuv";
	m['9'] = "wxyz";
	
	string temp = "";
	phnum(ans, num, m, 0, temp);
    sort(ans.begin(), ans.end());

	/*int k = 1;
	for(int i = 0; i<n; i++){
	    k = k*m[num[i]].length();
	}
	if(n == 1){
	    for(int i = 0; i<m[num[0]].length(); i++){
	        string e = "";
	        e = e + m[num[0]][i];
	        ans.push_back(e);
	    }
	}
	else if(n){
	    
	}
	else if(n == 2 && (num[0] == '0' || num[0] == '1')){
	    string g = "";
	    g = g+m[num[]]
	    for(int i = 0; i<m[num[1]].length(); i++){
	        string e = "";
	        e = e + m[num[0]][i];
	        ans.push_back(e);
	    }
	}
	else{
    	vector<int>d(n, 0);
    	
    	string s = "";
    	for(int i = 0; i<n; i++){
    	    s = s+'a';
    	}
    	int count1 = 0;
    	phnum(ans, num, n, m, s, d, k, count1);
    	string t = "";
    	for(int i = 0; i<n; i++){
    	    t+=m[f[i]][m[f[i]].length()-1];
    	}
    	ans.erase(ans.begin());
    	ans.pop_back();
    	ans.push_back(t);
	}*/
	return ans;
}
