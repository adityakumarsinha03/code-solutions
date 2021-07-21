// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3820/

class Solution {

    int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            arr.add(nums[i]);
        }
        
        Collections.shuffle(arr, new Random());
        int[] nums1 = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            nums1[i] = arr.get(i);
        }
        return nums1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */