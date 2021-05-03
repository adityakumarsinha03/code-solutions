// https://practice.geeksforgeeks.org/problems/combination-sum-1587115620/1#

class Solution
{
    static ArrayList<ArrayList<Integer>> ans;
    static Map<List<Integer>, Integer> mp;
    static void combinationSumUtil(ArrayList<Integer> a, int n, int i, int b, int sum, ArrayList<Integer> temp){
        if(sum == b){
            if(!mp.containsKey(temp)){
                ans.add(new ArrayList<Integer>(temp));
                mp.put(temp, 1);
            }
            return;
        }
        if(i>=n || sum>b){
            return;
        }
        
        for(int j = i; j<n; j++){
            temp.add(a.get(j));
            combinationSumUtil(a, n, j, b, sum+a.get(j), temp);
            temp.remove(temp.size()-1);
        }
        return;
    }

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        ans = new ArrayList<ArrayList<Integer>>();
        mp = new HashMap<>();
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        // REMOVING THE DUPLICATE IS VERY IMPORTANT
        Set<Integer> set = new HashSet<>(A);
        A.clear();
        A.addAll(set);
        Collections.sort(A);
        
        int N = A.size();
        combinationSumUtil(A, N, 0, B, 0, temp);
        return ans;
    }
}