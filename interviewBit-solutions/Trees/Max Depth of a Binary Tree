/*

Given a binary tree, find its maximum depth.

The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.

 NOTE : The path has to end on a leaf node. 
Example :

         1
        /
       2
max depth = 2.

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
int max_depth; 
void maxD(TreeNode* root, int h){
    if(root==NULL){
        return;
    }
    h++;
    if(root->left == NULL && root->right == NULL){
        max_depth = max(max_depth, h);
    }
    maxD(root->left, h);
    maxD(root->right, h);
} 
 
int Solution::maxDepth(TreeNode* A) {

    max_depth = 0;
    maxD(A, 0);
    return max_depth;
}
