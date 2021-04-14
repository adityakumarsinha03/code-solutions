// https://practice.geeksforgeeks.org/problems/search-in-a-matrix-1587115621/1

import java.io.*;
import java.util.*;

class GFG{
	public static void main(String args[]) throws IOException { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
       		int rows=sc.nextInt();
       		int columns=sc.nextInt();
			
			int matrix[][]=new int[rows][columns];
          
        	for(int i=0; i<rows;i++){            
            	for(int j=0; j<columns;j++){
                	matrix[i][j]=sc.nextInt();
            	}
         	}
         	int target = sc.nextInt();
         	
			Solution x = new Solution();
			
			if (x.search(matrix, rows, columns, target)) 
				System.out.println(1); 
			else
				System.out.println(0); 
			t--;
		}
	} 
}

class Solution 
{ 
	static boolean search(int matrix[][], int n, int m, int x) 
	{  
	    int x1 = -1, x2 = -1, y1 = -1, y2 = -1;
	    for(int i = 0; i<m; i++){
	        if(matrix[0][i] < x)
	            continue;
	        else if(matrix[0][i] == x)
	            return true;
	        else{
	            y1 = i-1;
	            y2 = i;
	            break;
	        }
	    }
	    for(int i = 0; i<n; i++){
	        if(matrix[i][0] < x)
	            continue;
	        else if(matrix[i][0] == x)
	            return true;
	        else{
	            x1 = i-1;
	            x2 = i;
	            break;
	        }
	    }
	    if(x1 < 0)  x1 = 0;
	    if(y1 < 0)  y1 = 0;
	    if(x2 < 0)  x2 = n-1;
	    if(y2 < 0)  y2 = m-1;
	   // System.out.println(x1 + " " + x2 + " " + y1 +" " + y2);
	    for(int i = 0; i<n; i++){
	        if(matrix[i][y1] == x || matrix[i][y2] == x)
	            return true;
	    }
	    for(int i = 0; i<m; i++){
	        if(matrix[x1][i] == x || matrix[x2][i] == x)
	            return true;
	    }
	    return false;
	} 
} 