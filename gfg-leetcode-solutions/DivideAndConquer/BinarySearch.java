// https://practice.geeksforgeeks.org/problems/binary-search/1

class Solution {
    int binarysearch(int arr[], int n, int k){
        int l = 0, r = n;
        int mid;
        
        while(l<r){
            mid = l + (r-l)/2;
            if(arr[mid] == k)
                return mid;
            else if(arr[mid] > k)
                r = mid;
            else
                l = mid+1;
        }
        return -1;
    }
}