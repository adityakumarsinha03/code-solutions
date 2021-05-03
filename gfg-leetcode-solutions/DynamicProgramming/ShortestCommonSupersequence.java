// https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}
}

class Solution
{
    public static int longestCommonSubsequence(String X,String Y,int m,int n){
        int dp[][] = new int[m+1][n+1];
        for(int i = 0; i<=m; i++){
            Arrays.fill(dp[i], 0);
        }
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(X.charAt(i-1) == Y.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else{
                    dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }
        return dp[m][n];
    }
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        int lcs = longestCommonSubsequence(X, Y, m, n);
        return m+n-lcs;
    }
}