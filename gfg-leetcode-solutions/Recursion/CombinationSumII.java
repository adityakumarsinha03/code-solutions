// https://practice.geeksforgeeks.org/problems/combination-sum-part-21208/1#

class Solution
{
    static List<List<Integer>> ans;
    static Map<List<Integer>, Integer> mp;
    static void combinationSumUtil(int a[], int n, int i, int b, int sum, List<Integer> temp){
        if(sum == b){
            if(!mp.containsKey(temp)){
                ans.add(new ArrayList<Integer>(temp));
                mp.put(temp, 1);
            }
            return;
        }
        if(i>=n){
            return;
        }
        
        for(int j = i; j<n; j++){
            temp.add(a[j]);
            combinationSumUtil(a, n, j+1, b, sum+a[j], temp);
            temp.remove(temp.size()-1);
        }
    }
    static List<List<Integer>> combinationSum(int A[], int N, int B)
    {
        ans = new ArrayList<List<Integer>>();
        mp = new HashMap<>();
        
        List<Integer> temp = new ArrayList<>();
        
        Arrays.sort(A);
        combinationSumUtil(A, N, 0, B, 0, temp);
        return ans;
    }
}