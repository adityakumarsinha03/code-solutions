// https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { // O(min(log m, log n))
        
        int n = nums1.length;
        int m = nums2.length;
        
        if(n>m)
            return findMedianSortedArrays(nums2, nums1);
        
        int start = 0;
        int end = n;
        
        int midMerged = (n+m+1)/2;
        
        while(start <= end){
            int mid = (start + end)/2;
            int leftASize = mid;
            int leftBSize = midMerged - leftASize;
            
            int leftA = (leftASize>0) ? nums1[leftASize-1] : Integer.MIN_VALUE;
            int leftB = (leftBSize>0) ? nums2[leftBSize-1] : Integer.MIN_VALUE;
            int rightA = (leftASize<n) ? nums1[leftASize] : Integer.MAX_VALUE;
            int rightB = (leftBSize<m) ? nums2[leftBSize] : Integer.MAX_VALUE;
            
            if(leftA <= rightB && leftB <= rightA){
                if((m+n)%2 == 0)
                    return (Math.max(leftA, leftB)+Math.min(rightA, rightB))/2.0;
                else
                    return Math.max(leftA, leftB);
            }
            else if(leftA > rightB){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return 0.0;
    }
}