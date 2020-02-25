/*package whatever //do not write package name here 
* https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t > 0){
		    
		    int n = sc.nextInt();
		    long s = sc.nextLong();
		    
		    long sum = 0;
		    int ar[] = new int[n];
		    for(int i = 0; i<n; i++){
		      ar[i] = sc.nextInt();
		      sum += ar[i];
		    }
		    
		    int st = 0;
		    
		    int flag = 0;
		    long tempsum = 0;
		    for(int i = 0; i<n; i++){
		        tempsum += ar[i];
		        
		        while(tempsum>s){
		            tempsum -= ar[st];
		            st++;
		        }
		        
		        if(tempsum == s){
		            flag = 1;
		            System.out.println((st+1) + " " + (i+1));
		            break;
		        }
		    }
		    if(flag == 0){
		        System.out.println(-1);
		    }
		    t--;
		}
	}
}