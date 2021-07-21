// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3731/

class Solution {
    
    public boolean checkAgain(int[] nums) {
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1])
                return false;
        }
        return true;
    }
    public boolean checkPossibility(int[] nums) {
        int index = -1;
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                index = i;
                break;
            }
        }
        
        // [4,2,3]
		// [1,2,4,5,3]
        if(index==-1 || index == nums.length-2)
            return true;
        
        int temp = nums[index];
        nums[index] = nums[index+1];
        if(checkAgain(nums) == true)
            return true;
        
        // [5,7,1,8]
        nums[index] = temp;
        nums[index+1] = nums[index+2];
        if(checkAgain(nums) == true)
            return true;
        return false;
    }
}