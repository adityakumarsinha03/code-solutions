// https://practice.geeksforgeeks.org/problems/next-higher-palindromic-number-using-the-same-set-of-digits5859/1#

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			String s = sc.next();
			Solution obj = new Solution();
			System.out.println(obj.nextPalin(s));
		}
			
	}
}

class Solution
{
    /*public static String next_permutation(String s) {
    	int len = s.length();
    	int i = len - 1;
    
    	while (i > 0) {
    		if (Character.compare(s.charAt(i - 1), s.charAt(i)) < 0) break;
        	i--;
      	}
    
      	if (i <= 0) return "-1";
    
      	int j = len - 1;
      	while (j >= i) {
        	if (Character.compare(s.charAt(i - 1), s.charAt(j)) < 0) break;
        	j--;
      	}
      	s = swap(i - 1, j, s);
    
      	len--;
      	while (i < len) {
        	s = swap(i, len, s);
        	len--;
        	i++;
      	}
      	return s;
    }*/
    
    /*public static String swap(int i, int j, String str)
    {
        if (j == str.length() - 1)
            return str.substring(0, i) + str.charAt(j)
                + str.substring(i + 1, j) + str.charAt(i);
  
        return str.substring(0, i) + str.charAt(j)
            + str.substring(i + 1, j) + str.charAt(i)
            + str.substring(j + 1, str.length());
    }*/
    
    public static boolean next_permutation(char[] ch) {
    	int len = ch.length;
    	int i = len - 1;
    
    	while (i > 0) {
    		if (Character.compare(ch[i-1], ch[i]) < 0) break;
        	i--;
      	}
    
      	if (i <= 0) return false;
    
      	int j = len - 1;
      	while (j >= i) {
        	if (Character.compare(ch[i-1], ch[j]) < 0) break;
        	j--;
      	}
      	swap(i - 1, j, ch);
    
      	len--;
      	while (i < len) {
        	swap(i, len, ch);
        	len--;
        	i++;
      	}
      	return true;
    }
    
    public static void swap(int x, int y, char[] arr) {
      	char temp = arr[x];
      	arr[x] = arr[y];
      	arr[y] = temp;
    }
    public String nextPalin(String s) 
    { 
        int len = s.length();

        char[] ch1 = new char[len/2];
        for(int i = 0; i<len/2; i++){
            ch1[i] = s.charAt(i);
        }
        
        boolean chP = next_permutation(ch1);
        if(chP == false)
            return "-1";
        
        String ans = "";
        for(int i = 0; i<len/2; i++){
            ans = ans + Character.toString(ch1[i]);
        }
        
        if(len%2 == 1)
            ans += Character.toString(s.charAt(len/2));
        for(int i = (len/2)-1; i>=0; i--){
            ans = ans + Character.toString(ch1[i]);
        }
        return ans;
        /*if(len%2 == 0){
            String temp = s.substring(0, len/2);
            temp = next_permutation(temp);
            if(temp == "-1")
                return temp;
            StringBuilder revTemp = new StringBuilder();
            revTemp.append(temp);
            revTemp.reverse();
            return temp+revTemp.toString();
        } else{
            String temp = s.substring(0, len/2);
            temp = next_permutation(temp);
            if(temp == "-1")
                return temp;
            StringBuilder revTemp = new StringBuilder();
            revTemp.append(temp);
            revTemp.reverse();
            return temp+Character.toString(s.charAt(len/2))+revTemp.toString();
        }*/
    }
}
