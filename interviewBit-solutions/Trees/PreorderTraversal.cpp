/*

Given a binary tree, return the preorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,2,3].

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
vector<int> Solution::preorderTraversal(TreeNode* root){
    
    TreeNode* curr = root;
    stack<TreeNode*>s;
    vector<int>a;
    if(root == NULL){
        return a;
    }
    s.push(root);
    while(!s.empty()){
        TreeNode* temp = s.top();
        s.pop();
        a.push_back(temp->val);
        if(temp->right!=NULL){
            s.push(temp->right);
        }
        if(temp->left != NULL){
            s.push(temp->left);
        }
    }
    return a;
}
