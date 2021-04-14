// https://practice.geeksforgeeks.org/problems/b6b608d4eb1c45f2b5cace77c4914f302ff0f80d/1

import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            long array[] = new long[n];
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextLong();
            }
            Solution ob = new Solution();
            System.out.println(ob.smallestpositive(array,n));
            t--;
        }
    } 
} 

class Solution { 
    long smallestpositive(long[] array, int n){ 
        
        Arrays.sort(array);
        long ans = 1;
        
        for(int i = 0; i<n && array[i] <= ans; i++)
            ans = ans+array[i];
            
        return ans;
    }
} 