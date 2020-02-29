/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/count-the-triplets/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int countTriplets(int a[]){
        int n = a.length;
        int ans = 0;
        
        Arrays.sort(a);
        int i = n-1;
        int j, k;
        while(i>=0){
            j = 0;
            k = i-1;
            while(j<k){
                if(a[j]+a[k] < a[i]){
                    j++;
                }
                else if(a[j]+a[k] > a[i]){
                    k--;
                }
                else{
                    ans++;
                    j++;
                    k--;
                }
            }
            i--;
        }
        return (ans>0)?ans:-1;
    }
	public static void main (String[] args) throws IOException {
		InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r); 
		
		int t = Integer.parseInt(br.readLine());
		
		while(t > 0){
		    
		    int n = Integer.parseInt(br.readLine());
		    
		    int ar[] = new int[n];
		    
		    String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            
		    for(int i = 0; i<n; i++){
		      ar[i] = Integer.parseInt(strs[i]);
		    }
		    System.out.println(countTriplets(ar));
		    t--;
		}
	}
}