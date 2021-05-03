// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}
class Solution 
{
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj, int s, int vis[], int recStack[]){
        if(vis[s] == 0){
            vis[s] = 1;
            recStack[s] = 1;
            
            for(int i = 0; i<adj.get(s).size(); i++){
                int p = adj.get(s).get(i);
                if(vis[p] == 0){
                    if(isCyclic(V, adj, p, vis, recStack))
                        return true;
                }
                else if(recStack[p] == 1)
                    return true;
            }
        }
        recStack[s] = 0;
        return false;
    }
    //Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int vis[] = new int[V];
        Arrays.fill(vis, 0);
        
        int recStack[] = new int[V];
        Arrays.fill(recStack, 0);
        
        for(int i = 0; i<V; i++){
            if(isCyclic(V, adj, i, vis, recStack))
                return true;
        }
        return false;
    }
}