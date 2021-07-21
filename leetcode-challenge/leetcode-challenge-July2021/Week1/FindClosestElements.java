// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3800/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> ans = new ArrayList<>();
        
        int n = arr.length;
        int[] arr1 = new int[n];
        
        int minEle = Integer.MAX_VALUE;
        int minEleInd = 0;
        for(int i = 0; i<n; i++){
            arr1[i] = Math.abs(arr[i]-x);
            if(minEle > arr1[i]){
                minEle = Math.min(minEle, arr1[i]);
                minEleInd = i;
            }
        }
        
        int p = minEleInd-1;
        int q = minEleInd+1;
        
        ans.add(arr[minEleInd]);
        
        while(ans.size()<k && (p>=0 && q<n)){
            if(arr1[p] > arr1[q]){
                ans.add(arr[q]);
                q++;
            }
            else if(arr1[p] < arr1[q]){
                ans.add(arr[p]);
                p--;
            }
            else{
                if(arr[p]<=arr[q]){
                    ans.add(arr[p]);
                    p--;
                } else{
                    ans.add(arr[q]);
                    q++;
                }
            }
        }
        
        while(p>=0 && ans.size()<k){
            ans.add(arr[p]);
            p--;
        }
        while(q<n && ans.size()<k){
            ans.add(arr[q]);
            q++;
        }
        
        Collections.sort(ans);
        return ans;
    }
}