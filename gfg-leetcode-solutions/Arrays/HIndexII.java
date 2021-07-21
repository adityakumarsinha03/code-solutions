// https://leetcode.com/problems/h-index-ii/submissions/

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        
        Arrays.sort(citations);
        int ans = 0;
        for(int i = n-1; i>=0; i--){
			ans = Math.max(ans, Math.min(n-i, citations[i]));
        }
        return ans;
    }
}