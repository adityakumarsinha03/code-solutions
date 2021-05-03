// https://practice.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array0624/1#

import java.util.*;

public class GFG 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++){
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}

class Solution 
{
    int ans;
    void findOnceUtil(int arr[], int n, int l, int r){
        if(l>r)
            return;
            
        if(l == r){
            ans = arr[l];
            return;
        }
        int mid = (l+r)/2;
        
        if(mid%2 == 0){
            if(arr[mid] == arr[mid+1])
                findOnceUtil(arr, n, mid+2, r);
            else
                findOnceUtil(arr, n, l, mid);
        }
        else{
            if (arr[mid] == arr[mid-1])
                findOnceUtil(arr, n, mid+1, r);
            else
                findOnceUtil(arr, n, l, mid-1);
        }
    }
    int findOnce(int arr[], int n)
    {
        findOnceUtil(arr, n, 0, n-1);
        return ans;
    }
}