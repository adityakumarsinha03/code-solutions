// https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}

class Solution{
    static int equalPartition(int n, int arr[])
    {
        Arrays.sort(arr);
        
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += arr[i];
        }
        
        if(sum%2 == 1)
            return 0;
            
        sum = sum/2;
        int dp[][] = new int[n+1][sum+1];
        for(int i = 0; i<=n; i++){
            dp[i][0] = 0;
        }
        
        for(int i = 0; i<=sum; i++){
            dp[0][i] = 0;
        }
        
        for(int i = 1; i<=n; i++){
            for(int j = 1 ; j<=sum; j++){
                if(j == arr[i-1] || dp[i-1][j] == 1 || (j-arr[i-1]>=0 && dp[i-1][j-arr[i-1]] == 1))
                    dp[i][j] = 1;
                else
                    dp[i][j] = 0;
            }
        }
        return dp[n][sum];
    }
}