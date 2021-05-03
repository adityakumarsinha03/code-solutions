// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3344/

class Solution {
    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer> > courseDep){ 

        if (recStack[i]) 
            return true; 
        if (visited[i]) 
            return false; 
              
        visited[i] = true; 
        recStack[i] = true; 
        ArrayList<Integer> children = courseDep.get(i); 
          
        for (Integer c: children) 
            if (isCyclicUtil(c, visited, recStack, courseDep) == true) 
                return true; 
                 
        recStack[i] = false; 
        return false; 
    } 
    private boolean isCyclic(int n, ArrayList<ArrayList<Integer> > courseDep){ 

        boolean[] visited = new boolean[n]; 
        boolean[] recStack = new boolean[n]; 
    
        for (int i = 0; i < n; i++) 
            if (isCyclicUtil(i, visited, recStack, courseDep)) 
                return true; 
  
        return false; 
    } 
    private void topoSortUtil(int i, boolean vis[], Stack<Integer> st, ArrayList<ArrayList<Integer> > courseDep){
        vis[i] = true;
        
        for(int j = 0; j<courseDep.get(i).size(); j++){
            if(vis[j] == false)
                topoSortUtil(j, vis, st, courseDep);
        }
        st.push(new Integer(i));
    }
    private boolean topoSort(int n, ArrayList<ArrayList<Integer> > courseDep){
        
        if(isCyclic(n, courseDep) == true)
            return false;
        
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[n];
        for(int i = 0; i<n; i++)
            vis[i] = false;
        
        for(int i = 0; i<n; i++){
            if(vis[i] == false)
                topoSortUtil(i, vis, st, courseDep);
        }
        if(st.size() != n)
            return false;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int n = prerequisites.length;
        ArrayList<ArrayList<Integer> > courseDep = new ArrayList<ArrayList<Integer> >(numCourses);
        for(int i = 0; i<numCourses; i++)
            courseDep.add(new ArrayList<>());
        
        for(int i = 0; i<n; i++)
            courseDep.get(prerequisites[i][0]).add(prerequisites[i][1]);
 
        return topoSort(numCourses, courseDep);
    }
}