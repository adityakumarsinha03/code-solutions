/*

Suppose a sorted array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array will not contain duplicates.

*/

Solution:

int Solution::findMin(const vector<int> &a){
    
    int n = a.size();
    if(a[0]<=a[n-1]){
        return a[0];
    }
    int low = 0;
    int high = n-1;
    int mid;
    while(low <= high){
        mid = (low+high)/2;
        if(mid-1>=0 && mid+1<n && a[mid]<a[mid-1] && a[mid]<a[mid+1]){
            return a[mid];
        }
        else if(a[mid]<a[high]){
            high = mid-1;
        }
        else if(a[mid]>a[high]){
            low = mid+1;
        }
    }
}
