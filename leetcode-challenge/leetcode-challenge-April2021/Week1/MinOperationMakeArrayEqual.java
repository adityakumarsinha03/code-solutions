class Solution {
    public int minOperations(int n) {
        int ans = 0;
        for(int i = 0; i<n; i++){
            int x = (2*i)+1;
            ans = ans + Math.abs(n - x);
        }
        return ans/2;
    }
}