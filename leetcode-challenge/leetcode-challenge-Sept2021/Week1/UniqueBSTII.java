// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3961/

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
class Solution {
    public List<TreeNode> funcUtil(int start, int end){
        
        List<TreeNode> tl = new ArrayList<>();
        if(start > end){
            tl.add(null);
            return tl;
        }
        
        for(int i = start; i<=end; i++){
            List<TreeNode> left_tree = funcUtil(start, i-1);
            List<TreeNode> right_tree = funcUtil(i+1, end);
            
            for(int j = 0; j<left_tree.size(); j++){
                TreeNode left = left_tree.get(j);
                for(int k = 0; k<right_tree.size(); k++){
                    TreeNode right = right_tree.get(k);
                    
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    tl.add(root);
                }
            }
        }
        return tl;
    }
    public List<TreeNode> generateTrees(int n) {
        
        List<TreeNode> treeList = new ArrayList<>();
        if(n == 0)
            return treeList;
        
        treeList = funcUtil(1, n);
        return treeList;
    }
}