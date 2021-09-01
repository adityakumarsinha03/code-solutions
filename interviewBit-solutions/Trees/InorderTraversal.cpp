/*

Given a binary tree, return the inorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,3,2].

Using recursion is not allowed.

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
vector<int> Solution::inorderTraversal(TreeNode* root){
    
    vector<int>ans;
    if(root == NULL){
        return ans;
    }
        TreeNode* curr = root;
    stack<TreeNode*>s;
    s.push(root);
    while(curr->left!=NULL){
        s.push(curr->left);
        curr = curr->left;
    }
    while(!s.empty()){
        curr = s.top();
        s.pop();
        ans.push_back(curr->val);
        if(curr->right != NULL){
            s.push(curr->right);
            TreeNode* temp = curr->right;
            while(temp->left != NULL){
                s.push(temp->left);
                temp = temp->left;
            }
        }
    }
    return ans;
}
