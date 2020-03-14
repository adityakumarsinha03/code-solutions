/*

Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm’s runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example:

Given [5, 7, 7, 8, 8, 10]

and target value 8,

return [3, 4].

*/

Solution:

/*int binsear(vector<int>a, int st, int en, int x){
    
    int low = st;
    int high = en;
    int mid;
    while(low <= high){
        mid = (low+high)/2;
        if(a[mid]==x){
            return mid;
        }
        else if(a[mid]>x){
            high = mid-1;
        }
        else{
            low = mid+1;
        }
    }
    return -1;
}
*/
vector<int> Solution::searchRange(const vector<int> &a, int x) {
    
    int n = a.size();
    vector<int>ans;
    
    int st = 0, en = n-1;
    int mid = 0;
    int rStart = -1;
    while(st < en){
        mid = (en+st)/2;            
        if(x > a[mid]){
            st = mid + 1;
        }
        else{
            en = mid;
        }
    }     
    int low;
    if(x != a[st]){
        ans.push_back(-1);
        ans.push_back(-1);
        return ans;
    }
    else{ 
        low = st;
    }
    st = 0;
    en = n -1;
    while(st < en){
        mid = (en+st)/2;
        if(a[mid] < x + 1){
            st = mid + 1;
        }
        else{
            en = mid;
        }
    }        
    int high = 0;
    if(a[st] == x){
        high = st;
    }
    else{
        high = st - 1;
    }
    ans.push_back(low);
    ans.push_back(high);
    return ans;
    
    /*int st = 0;
    int en = n-1;
    int left, right;
    int mid = binsear(a, st, en, x);
    if(x<=a[n-1] && x>=a[0] && mid != -1){
        // for left
        left = mid;
        while(a[left-1] == x){
             int y = binsear(a, st, left-1, x);
             if(y!=-1){
                 left = min(y, left);
             }
        }
        
        // for right
        right = mid;
        while(a[right+1] == x){
             int y = binsear(a, right+1, en, x);
             if(y!=-1){
                 right = max(y, right);
             }
        }
    }
    else{
        left = -1;
        right = -1;
    }
    ans.push_back(left);
    ans.push_back(right);
    return ans;*/
}
