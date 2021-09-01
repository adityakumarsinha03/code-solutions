/*

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 NOTE : The path has to end on a leaf node. 
Example :

         1
        /
       2
min depth = 2.

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
int min_depth;
void minD(TreeNode* root, int h){
    
    if(root == NULL){
        return;
    }
    h++;
    if(root->left == NULL && root->right == NULL){
        min_depth = min(min_depth, h);
    }
    minD(root->left, h);
    minD(root->right, h);
}
int Solution::minDepth(TreeNode* A) {
    
    min_depth = INT_MAX;
    minD(A, 0);
    return min_depth;
}
