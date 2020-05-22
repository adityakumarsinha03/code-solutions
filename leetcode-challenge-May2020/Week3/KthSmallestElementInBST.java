/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3335/
 * 
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    int count = 0;

    public TreeNode inOrder(TreeNode root, int k) {
        if (root == null)
            return null;

        TreeNode left = inOrder(root.left, k);
        if (left != null)
            return left;

        count++;
        if (count == k)
            return root;
        return inOrder(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        return inOrder(root, k).val;
    }
}