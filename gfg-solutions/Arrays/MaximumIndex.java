/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/maximum-index/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int maxIndex(int a[]){
        
        int n = a.length;
        int left[] = new int[n];
        int right[] = new int[n];
        
        left[0] = a[0];
        for(int i = 1; i<n; i++){
            left[i] = Math.min(a[i], left[i-1]);
        }
        
        right[n-1] = a[n-1];
        for(int j = n-2; j>=0; j--){
            right[j] = Math.max(a[j], right[j+1]);
        }
        
        int ans = 0;
        int i = 0, j = 0;
        while(i<n && j<n){
            if(left[i] <= right[j]){
                ans = Math.max(ans, (j-i));
                j = j+1;
            } else{
                i = i+1;
            }
        }
        return ans;
    }
	public static void main (String[] args) throws IOException {
		InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r); 
		
		int t = Integer.parseInt(br.readLine());
		
		while(t > 0){
		    
		    int n = Integer.parseInt(br.readLine());
		    
		    int a[] = new int[n];
		    
		    String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            
		    for(int i = 0; i<n; i++){
		      a[i] = Integer.parseInt(strs[i]);
		    }
		    
		    int ans = maxIndex(a);
		    System.out.println(ans);
		    t--;
		}
	}
}