/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/n-queen-problem/0

import java.util.*;
import java.lang.*;
import java.io.*;

class NQueenAllSolutions {
    public static ArrayList<ArrayList<Integer> > ans = new ArrayList<ArrayList<Integer> >();
    
    public static boolean isSafe(int board[][], int row, int col, int n){
        for(int j = 0; j<col; j++){
            if(board[row][j]==1)
                return false;
        }
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(board[i][j]==1)
                return false;
        }
        for(int i=row, j=col; i<n && j>=0; i++, j--){
            if(board[i][j]==1)
                return false;
        }
        return true;
    }
    public static boolean nQueenUtil(int board[][], int col, int n){
        if(col==n){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i = 0; i<n; i++){
		        for(int j = 0; j<n; j++){
		            if(board[i][j] == 1){
		                temp.add(j+1);
		            }
		        }
		    }
		    ans.add(temp);
            return true;
        }
        
        boolean res = false;
        for(int i = 0; i<n; i++){
            if(isSafe(board, i, col, n)==true){
                board[i][col] = 1;
                res = nQueenUtil(board, col+1, n) || res;
                board[i][col] = 0;
            }
        }
        return res;
    }
	public static void main (String[] args) throws IOException {
		InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r); 
		
		int t = Integer.parseInt(br.readLine());
		
		while(t > 0){
		    ans.clear();
		    int n = Integer.parseInt(br.readLine());
		    int board[][] = new int[n][n];
		    for(int i = 0; i<n; i++){
		        for(int j = 0; j<n; j++){
		            board[i][j] = 0;
		        }
		    }
		    if(nQueenUtil(board, 0, n)==false){
		        System.out.println(-1);
		    } else{
                Collections.sort(ans, new Comparator<ArrayList<Integer>>(){
                    public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2){
                        int result = 0;
                        for (int i = 0; i <= list1.size() - 1 && result == 0; i++) 
                        {
                            result = list1.get(i).compareTo(list2.get(i));
                        }
                        return result;
                    }
                });
		        for(int i = 0; i<ans.size(); i++){
		            System.out.print("[");
    		        for(int j = 0; j<ans.get(i).size(); j++){
    		            System.out.print(ans.get(i).get(j) + " ");
    		        }
    		        System.out.print("] ");
    		    }
    		    System.out.println();
		    }
		    t--;
		}
	}
}