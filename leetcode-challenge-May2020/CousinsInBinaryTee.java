/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/
 * 
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return true;

        if (root.val == x || root.val == y)
            return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(new TreeNode(-1));

        int flagx, flagy;
        while (!q.isEmpty()) {
            TreeNode temp = q.peek();
            flagx = 0;
            flagy = 0;
            if (temp.val != -1) {
                while (!q.isEmpty() && q.peek().val != -1) {
                    temp = q.poll();
                    if (temp.left != null)
                        q.add(temp.left);
                    if (temp.right != null)
                        q.add(temp.right);
                    if (temp.left != null && temp.right != null && temp.left.val == x && temp.right.val == y)
                        return false;
                    if (temp.left != null && temp.right != null && temp.left.val == y && temp.right.val == x)
                        return false;
                    if ((temp.left != null && temp.left.val == x) || (temp.right != null && temp.right.val == x))
                        flagx = 1;
                    if ((temp.left != null && temp.left.val == y) || (temp.right != null && temp.right.val == y))
                        flagy = 1;

                }
                if (flagx == 1 && flagy == 1)
                    return true;
                else if (flagx != 0 || flagy != 0)
                    return false;
                q.add(new TreeNode(-1));
            } else
                q.poll();
        }
        return false;
    }
}