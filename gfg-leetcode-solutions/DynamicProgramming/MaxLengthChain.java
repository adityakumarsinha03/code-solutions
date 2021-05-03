// https://practice.geeksforgeeks.org/problems/max-length-chain/1

class CompareBySecond implements Comparator<Pair>
{
   public int compare(Pair a, Pair b)
    {
        return a.y - b.y;
    }
}

class GfG
{
    int maxChainLength(Pair arr[], int n)
    {
        Arrays.sort(arr, new CompareBySecond());
        
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        
        int last = arr[0].y;
        for(int i = 1; i<n; i++){
            if(arr[i].x > last){
                dp[i] = dp[i-1]+1;
                last = arr[i].y;
            }
            else
                dp[i] = dp[i-1];
        }
        return dp[n-1];
    }
}