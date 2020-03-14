/*

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

You are given a target value to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Input : [4 5 6 7 0 1 2] and target = 4
Output : 0

*/

Solution:

int Solution::search(const vector<int> &a, int b){
    
    int n = a.size();
    if(n == 0){
        return -1;
    }
    if(n == 1 && a[0] == b){
        return 0;
    }
    int low = 0;
    int high = n-1;
    int mid;
    int flag = 0;
    while(low<=high){
        mid = (low+high)/2;
        if(a[mid] == b){
            flag = 1;
            break;
        }
        else if(a[mid] <= a[high]){
            if(b<=a[high] && b>a[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        else{
            if(b>=a[low] && b<a[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
    }
    if(flag == 1){
        return mid;
    }
    else{
        return -1;
    }
}
