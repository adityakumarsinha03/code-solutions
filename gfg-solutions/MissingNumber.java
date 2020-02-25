/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0){
		    int n = sc.nextInt();
		    int ar[] = new int[n-1];
		    
		    int xorInit = 0;
		    for(int i = 1; i<=n; i++){
		        xorInit = xorInit^i;
		    }
		    
		    int xorFin = 0;
		    for(int i = 0; i<n-1; i++){
		        ar[i] = sc.nextInt();
		        xorFin = xorFin^ar[i];
		    }
		    System.out.println(xorInit^xorFin);
		    t--;
		}
	}
}