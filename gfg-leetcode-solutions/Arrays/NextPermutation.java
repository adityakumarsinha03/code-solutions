class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        int flag = 0;
        int k = 0;
        for(int i = n-1; i>0; i--){
            if(nums[i-1] < nums[i]){
                k = i-1;
                flag = 1;
                break;
            }
        }
        
        if(flag == 0){
            Arrays.sort(nums);
            return;
        }
        
        int maxm = nums[k+1];
        int index = k+1;
        for(int i = k+2; i<n; i++){
            if(nums[i]>nums[k] && nums[i]<maxm){
                maxm = nums[i];
                index = i;
            }
        }
        
        int temp = nums[k];
        nums[k] = maxm;
        nums[index] = temp;
        Arrays.sort(nums, k+1, n);
    }
}