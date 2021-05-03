// https://practice.geeksforgeeks.org/problems/find-optimum-operation/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public int minOperation(int n)
    {
        if(n <= 2)
            return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<=n; i++){
            if(i%2 == 1)
                dp[i] = Math.min(dp[i-1]+1, dp[i/2]+2);
            else
                dp[i] = Math.min(dp[i-1], dp[i/2]) + 1;
        }
        return dp[n];
    }
	
	public static void main (String[] args) throws IOException {
		
		InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r); 
		
		int t = Integer.parseInt(br.readLine());
		
		int dp[] = new int[10000];
		dp[0] = 1;
		dp[1] = 2;
		
		for(int i = 2; i<10000; i++){
		    if((i+1)%2==0)
		        dp[i] = dp[((i+1)/2)-1] + 1;
		    else
		        dp[i] = dp[i-1] + 1;
		}
		
		while(t>0){
		    
		    Integer n = Integer.parseInt(br.readLine());
		    System.out.println(dp[n-1]);
		    t--;
		}
	}
}