// https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}

class Solution
{
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        
        int i = 0;
        for(i = 0; i < k && i<n; i++){
            while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        
        for(; i<n; i++){
            ans.add(arr[dq.peekFirst()]);
            
			// remove out of reach indexes
            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.removeFirst();
            }
            
            while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        ans.add(arr[dq.peekFirst()]);
        return ans;
    }
}