// https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1

class Islands {

    // Function to find the number of island in the given list
    // N, M: size of list row and column respectively
    static void findIslandsUtil(ArrayList<ArrayList<Integer>> a, int n, int m, int vis[][], int r, int s){
    
        if(r<0 || s<0 || r>=n || s>=m){
            return;
        }
        if(vis[r][s]==1 || a.get(r).get(s)==0){
            return;
        }
        vis[r][s] = 1;
        findIslandsUtil(a, n, m, vis, r, s+1);
        findIslandsUtil(a, n, m, vis, r+1, s);
        findIslandsUtil(a, n, m, vis, r, s-1);
        findIslandsUtil(a, n, m, vis, r-1, s);
        findIslandsUtil(a, n, m, vis, r-1, s-1);
        findIslandsUtil(a, n, m, vis, r+1, s-1);
        findIslandsUtil(a, n, m, vis, r-1, s+1);
        findIslandsUtil(a, n, m, vis, r+1, s+1);
    }
    static int findIslands(ArrayList<ArrayList<Integer>> a, int n, int m) {

        int vis[][] = new int[n][m];
    
        int ans = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(vis[i][j]==0 && a.get(i).get(j)==1){
                    ans++;
                    findIslandsUtil(a, n, m, vis, i, j);
                }
            }
        }
        return ans;
    }
}