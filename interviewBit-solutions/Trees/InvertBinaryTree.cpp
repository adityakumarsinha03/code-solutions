/*

Given a binary tree, invert the binary tree and return it. 
Look at the example for more details.

Example : 
Given binary tree

     1
   /   \
  2     3
 / \   / \
4   5 6   7
invert and return

     1
   /   \
  3     2
 / \   / \
7   6 5   4


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
TreeNode* Solution::invertTree(TreeNode* root) {
    
    if(root == NULL){
        return NULL;
    }
    else if(root ->left == NULL && root->right == NULL){
        return root;
    }
    queue<TreeNode*>q;
    TreeNode* curr;
    q.push(root);
    while(!q.empty()){
        curr = q.front();
        if(curr->left != NULL){
            q.push(curr->left);
        }
        if(curr->right != NULL){
            q.push(curr->right);
        }
        TreeNode* temp;
        if(curr->left != NULL && curr->right != NULL){
            temp = curr->left;
            curr->left = curr->right;
            curr->right = temp;
        }
        
        q.pop();
    }
    
    return root;
}
