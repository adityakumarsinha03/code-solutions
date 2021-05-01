/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/parenthesis-checker/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static boolean paraBalance(String brackets){
        Stack<String> st = new Stack<String>();
	    for(int i = 0; i<brackets.length(); i++){
	        if(brackets.charAt(i)=='{' || brackets.charAt(i)=='(' || brackets.charAt(i)=='['){
	            st.push(String.valueOf(brackets.charAt(i)));
	        }
	        if(brackets.charAt(i)=='}'){
	            if(st.empty() || !st.peek().equals("{")){
	                return false;
	            } else{
	                st.pop();
	            }
	        }
	        else if(brackets.charAt(i)==')'){
	            if(st.empty() || !st.peek().equals("(")){
	                return false;
	            } else{
	                st.pop();
	            }
	        }
	        else if(brackets.charAt(i)==']'){
	            if(st.empty() || !st.peek().equals("[")){
	                return false;
	            } else{
	                st.pop();
	            }
	        }
	    }
	    if(!st.empty()){
	        return false;
	    }
	    return true;
    }
	public static void main (String[] args) throws IOException {
		//code
		InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r); 
		
		int t = Integer.parseInt(br.readLine());
		
		while(t > 0){
		    String brackets = br.readLine();
		    
		    if(paraBalance(brackets) == true){
		        System.out.println("balanced");
		    } else{
		        System.out.println("not balanced");
		    }
		    
		    t--;
		}
	}
}