// https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1#

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}

class Solution 
{
    public static int checkPossible(int[]A,int N,int M, int curr){
        int sum = 0;
        int students = 1;
        
        for(int i = 0; i<N; i++){
            if(A[i] > curr)
                return 0;
            if(sum + A[i] > curr){
                students++;
                
                sum = A[i];
                if(students > M)
                    return 0;
            } else{
                sum += A[i];
            }
        }
        return 1;
    }
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        if(N < M)
            return -1;
            
        long sum = 0;
        for(int i = 0; i<N; i++)
            sum += A[i];
            
		// Using Binary Search on Sum to find which gives minimum possible
        int start = 0;
        int end = (int) sum;
        
        int ans = Integer.MAX_VALUE;
        while(start <= end){
            int mid = (start+end)/2;
            
            if(checkPossible(A, N, M, mid) == 1){
                ans = mid;
                
                end = mid-1;
            } else{
                start = mid+1;
            }
        }
        return ans;
    }
};