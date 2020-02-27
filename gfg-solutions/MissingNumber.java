/*package whatever //do not write package name here */

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
		    		    
		    String line = br.readLine();
			String[] strs = line.trim().split("\\s+");
			
		    int ar[] = new int[n-1];
		    
		    int xorInit = 0;
		    for(int i = 1; i<=n; i++){
		        xorInit = xorInit^i;
		    }
		    
		    int xorFin = 0;
		    for(int i = 0; i<n-1; i++){
		        ar[i] = Integer.parseInt(strs[i]);
		        xorFin = xorFin^ar[i];
		    }
		    System.out.println(xorInit^xorFin);
		    t--;
		}
	}
}