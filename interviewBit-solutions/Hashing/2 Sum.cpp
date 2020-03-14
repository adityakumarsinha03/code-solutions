/*

Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based. 
Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.

Input: [2, 7, 11, 15], target=9
Output: index1 = 1, index2 = 2

*/

Solution:

vector<int> Solution::twoSum(const vector<int> &b, int k) {
    //vector<int>a;
    int n = b.size();
    map<int, vector<int> >m;
    for(int i = 0; i<n; i++){
        m[b[i]].push_back(i);
    }
    vector<int>vect(2, INT_MAX);
    for(int i = 0; i<n; i++){
        int y = k-b[i];
        if(m.find(y) != m.end()){
            int ind1 = i;
            int ind2 = INT_MAX;
		    for(int j = 0; j<m[y].size(); j++){
		        //select the minimum
		        if(m[y][j] != ind1 && m[y][j] < ind2){
		            ind2 = m[y][j];
		        }
		    }
            vector<int>d;
            d.push_back(ind1);
            d.push_back(ind2);
            sort(d.begin(), d.end());
            if(d[1]<vect[1]){
                vect[1] = d[1];
                vect[0] = d[0];
            }
            else if(d[1] == vect[1]){
                if(d[0] < vect[0]){
                    vect[0] = d[0];
                }
            }
        }
    }
    if(vect[0] == INT_MAX || vect[1] == INT_MAX){
        vect.erase(vect.begin(), vect.end());
    }
    else{
        vect[0]++;
        vect[1]++;
    }
    return vect;
}
