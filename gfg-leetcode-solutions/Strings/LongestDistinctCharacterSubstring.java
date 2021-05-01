// https://practice.geeksforgeeks.org/problems/longest-distinct-characters-in-string5848/1

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDitinctChars(S));
        }
    }
}

class Solution{
    static int longestSubstrDitinctChars(String S){
        int[] arr = new int[26];
        Arrays.fill(arr, 0);
        
        int n = S.length();
        int i = 1, j = 0;
        
        arr[S.charAt(0) -97]++;
        int ans = 1;
        while(i<n){
            int x = S.charAt(i);
            if(arr[x-97] == 0){
                arr[x-97]++;
                ans = Math.max(ans, i-j+1);
            }
            else{
                while(j<n && arr[x-97] > 0){
                    int y = S.charAt(j);
                    arr[y-97]--;
                    j++;
                }
                arr[x-97]++;
            }
            i++;
        }
        return ans;
    }
}