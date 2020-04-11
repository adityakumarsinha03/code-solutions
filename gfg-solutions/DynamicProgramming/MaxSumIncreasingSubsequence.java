// https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		
		InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r); 
		
		int t = Integer.parseInt(br.readLine());
		
		while(t>0){
		    
		    int n = Integer.parseInt(br.readLine());
		    
		    int ar[] = new int[n];
		    
		    String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            
		    for(int i = 0; i<n; i++){
		      ar[i] = Integer.parseInt(strs[i]);
		    }
		    int dp[] = new int[n];
		    dp[0] = ar[0];
		    int ans = dp[0];
		    
		    for(int i = 1; i<n; i++){
		        dp[i] = ar[i];
		        for(int j = 0; j<i; j++){
		            if(ar[i] > ar[j]){
		                dp[i] = Math.max(dp[i], dp[j]+ar[i]);
		                ans = Math.max(ans, dp[i]);
		            }
		        }
		    }
		    System.out.println(ans);
		    t--;
		}
	}
}