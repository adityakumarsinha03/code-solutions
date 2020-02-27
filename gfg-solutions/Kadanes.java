/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		//code
		InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r); 
		
		int t = Integer.parseInt(br.readLine());
		
		while(t > 0){
		    
		    int n = Integer.parseInt(br.readLine());
		    
		    int ar[] = new int[n];
		    
		    String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            
		    int posFlag = 0;
		    int maxEle = Integer.MIN_VALUE;
		    for(int i = 0; i<n; i++){
		      ar[i] = Integer.parseInt(strs[i]);
		      if(ar[i]>0){
		          posFlag = 1;
		      }
		      maxEle = Math.max(maxEle, ar[i]);
		    }
		    
		    if(posFlag == 0){
		        System.out.println(maxEle);
		    } else{
    		    long sum = 0;
    		    long maxsum = 0;
    		    
    		    for(int i = 0; i<n; i++){
    		        sum += ar[i];
    		        
    		        if(sum < 0){
    		            sum = 0;
    		        } else{
    		            maxsum = Math.max(sum, maxsum);
    		        }
    		    }
    		    System.out.println(maxsum);
		    }
		    t--;
		}
	}
}