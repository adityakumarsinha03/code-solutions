class FirstAndLastElementPositionInSortedArray {
    public int binarySearchFunc(int[] nums, int target){
        int n = nums.length;
        
        int low = 0;
        int high = n;
        
        int mid = 0;
        int ans = -1;
        while(low < high){
            mid = (low+high)/2;
            if(nums[mid] == target){
                ans = mid;
                if(mid+1<n && nums[mid+1]!=target){
                    ans = mid;
                    break;
                }
                low = mid+1;
            }
            else if(nums[mid] > target){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public int binarySearchFunc2(int[] nums, int target){
        int n = nums.length;
        
        int low = 0;
        int high = n;
        
        int mid = 0;
        int ans = -1;
        while(low < high){
            mid = (low+high)/2;
            if(nums[mid] == target){
                ans = mid;
                if(mid-1>=0 && nums[mid-1]!=target){
                    ans = mid;
                    break;
                }
                high = mid;
            }
            else if(nums[mid] > target){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        
        int key1 = binarySearchFunc(nums, target);
        int key2 = binarySearchFunc2(nums, target);
        
        ans[0] = key2;
        ans[1] = key1;
        
        return ans;        
    }
}