/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/
 */
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            Integer x = new Integer(nums[i]);
            if (mp.get(x) != null) {
                Integer count = mp.get(x) + 1;
                mp.put(x, count);
            } else {
                mp.put(x, 1);
            }
            if (mp.get(x) > (nums.length / 2)) {
                return x;
            }
        }
        return -1;
    }
}