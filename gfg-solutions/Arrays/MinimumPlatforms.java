/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/minimum-platforms/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int countPlatforms(int ar[], int dep[]){
        int n = ar.length;
        
        int ans = 0;
        Arrays.sort(ar);
        Arrays.sort(dep);
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            if(q.size()==0){
                q.add(i);
                ans = Math.max(ans, q.size());
            }
            else{
                int y = q.peek();
                while(q.size()>0 && dep[y] < ar[i]){
                    q.remove();
                    if(q.size()>0){
                        y = q.peek();
                    }
                }
                q.add(i);
                ans = Math.max(ans, q.size());
            }
            
        }
        return ans;
    }
	public static void main (String[] args) throws IOException {
		InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r); 
		
		int t = Integer.parseInt(br.readLine());
		
		while(t > 0){
		    
		    int n = Integer.parseInt(br.readLine());
		    
		    int ar[] = new int[n];
		    int dep[] = new int[n];
		    
		    String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            
		    for(int i = 0; i<n; i++){
		      ar[i] = Integer.parseInt(strs[i]);
		    }
		    
		    String line1 = br.readLine();
            String[] strs1 = line1.trim().split("\\s+");
            
		    for(int i = 0; i<n; i++){
		      dep[i] = Integer.parseInt(strs1[i]);
		    }
		    System.out.println(countPlatforms(ar, dep));
		    t--;
		}
	}
}