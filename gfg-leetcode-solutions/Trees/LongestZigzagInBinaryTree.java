// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/

/**
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
class Res {
    int val;
}
class Solution {
    Res res = new Res();
    
    public void func(TreeNode root, int prev, int len){
        
        if(root == null || (root.left==null && root.right==null))
            return;
        
        if(prev == 2 && root.left != null) {
            res.val = Math.max(res.val, len+1);
            func(root.left, 1, len+1);
        }
        else if(root.left != null)
            func(root.left, 1, 1);
        
        if(prev == 1 && root.right != null) {
            res.val = Math.max(res.val, len+1);
            func(root.right, 2, len+1);
        }
        else if(root.right != null)
            func(root.right, 2, 1);
        
    }
    public int longestZigZag(TreeNode root) {        
        
        if(root == null || (root.left==null && root.right==null))
            return 0;
        
        func(root, 2, 0);
        return res.val;
    }
}