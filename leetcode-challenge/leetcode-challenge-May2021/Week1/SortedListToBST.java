// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3733/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    ListNode current = new ListNode();
    int countNodes(ListNode head){
        int count = 0;
        ListNode temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public TreeNode sortedListToBSTUtil(int n) {
        if(n<=0)
            return null;
        
        TreeNode leftNode = sortedListToBSTUtil(n/2);
        TreeNode root = new TreeNode(current.val);
        root.left = leftNode;
        
        current = current.next;
        root.right = sortedListToBSTUtil(n-(n/2)-1);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        // count nodes
        int n = countNodes(head);
        current = head;
        return sortedListToBSTUtil(n);
    }
}