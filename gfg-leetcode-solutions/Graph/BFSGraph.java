// https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1#

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
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.bfsOfGraph(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}
class Solution
{
    ArrayList<Integer> ans;
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj)
    {
        int vis[] = new int[V];
        Arrays.fill(vis, 0);
        
        ans = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        while(!q.isEmpty()){
            int front = q.peek();
            q.remove();
            
            ans.add(front);
            vis[front] = 1;
            for(int i = 0; i<adj.get(front).size(); i++){
                if(vis[adj.get(front).get(i)] == 0){
                    vis[adj.get(front).get(i)] = 1;
                    q.add(adj.get(front).get(i));
                }
            }
        }
        return ans;
    }
}