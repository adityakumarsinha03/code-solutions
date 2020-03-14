/*

Given a binary tree, return the postorder traversal of its nodes’ values.

Example :

Given binary tree

   1
    \
     2
    /
   3
return [3,2,1].

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
vector<int> Solution::postorderTraversal(TreeNode* root){
    
    vector<int>a;
    if(root == NULL){
        return a;
    }
    stack<TreeNode*>s;
    while(!s.empty() || root!=NULL){
        while(root!=NULL){
            if(root->right != NULL){
                s.push(root->right);
            }
            s.push(root);
            root = root->left;
        }
        root = s.top();
        s.pop();
        if(!s.empty() && root->right != NULL && root->right == s.top()){
            TreeNode* temproot = s.top();
            s.pop();
            s.push(root);
            root = temproot;
        }
        else{
            a.push_back(root->val);
            root = NULL;
        }
    }
    return a;
}
