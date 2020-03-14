/*

Given a sorted array of integers, find the number of occurrences of a given target value.
Your algorithm’s runtime complexity must be in the order of O(log n).
If the target is not found in the array, return 0

**Example : **
Given [5, 7, 7, 8, 8, 10] and target value 8,
return 2.

*/

Solution:

int findIndex(vector<int>a, int b, bool first){
    int n = a.size();
    int result = -1;
    int low = 0;
    int high = n-1;
    while(low<=high){
        int mid = (low+high)/2;
        if(a[mid]==b){
            result = mid;
            if(first == true){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        else if(a[mid] > b){
            high = mid-1;
        }
        else{
            low = mid+1;
        }
    }
    return result;
}

int Solution::findCount(const vector<int> &a, int b){
    
    int n = a.size();
    int st = findIndex(a, b, true);
    int en;
    if(st!=-1){
        en = findIndex(a, b, false);
    }
    else{
        return 0;
    }
    return en-st+1;
}
