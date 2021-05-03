// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
class Solution
{
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj, int s, int vis[], int parent){
        vis[s] = 1;
        for(int i = 0; i<adj.get(s).size(); i++){
            int p = adj.get(s).get(i);
            if(vis[p] == 0){
                if(isCyclic(V, adj, p, vis, s))
                    return true;
            }
            else if(p!=parent)
                return true;
        }
        return false;
    }
    //Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int vis[] = new int[V];
        Arrays.fill(vis, 0);
        
        for(int i = 0; i<V; i++){
            if(vis[i] == 0 && isCyclic(V, adj, i, vis, -1))
                return true;
        }
        return false;
    }
}