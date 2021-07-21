/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSame(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
            return true;
        if((root != null && subRoot == null) || (root == null && subRoot != null))
            return false;
        
        if(root.val != subRoot.val)
            return false;
        else
            return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);   
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;
        
        if(isSame(root, subRoot))
            return true;
        
        else
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}