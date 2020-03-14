/*

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the 
 two subtrees of every node never differ by more than 1. 
Example :


Given A : [1, 2, 3]
A height balanced BST  : 

      2
    /   \
   1     3

*/

Solution:

/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

TreeNode* buildT(const vector<int>&a, int st, int en){
    
    if(st > en){
        return NULL;
    }
    int k = (st+en)/2;
    TreeNode* node = new TreeNode(a[k]);
    if(st == en){
        return node;
    }
    node->left = buildT(a, st, k-1);
    node->right = buildT(a, k+1, en);
    return node;
} 
 
TreeNode* Solution::sortedArrayToBST(const vector<int> &a){
    
    if(a.size() < 1){
        return NULL;
    }
    int n = a.size();
    return buildT(a, 0, n-1);
}
