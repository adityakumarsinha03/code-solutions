/*

Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
Also think about a version of the question where you are asked to do a level order traversal of the tree
when depth of the tree is much greater than number of nodes on a level.

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
vector<vector<int> > Solution::levelOrder(TreeNode* root){
    
    vector<vector<int> >ans;
    vector<int> temp;
    
    if(root == NULL){
        return ans;
    }
    queue<TreeNode*>q;
    q.push(root);
    q.push(NULL);
    while(!q.empty()){
        TreeNode* f = q.front();
        q.pop();
        if(f == NULL){
            ans.push_back(temp);
            temp.clear();
            if(q.empty()){
                break;
            }
            q.push(NULL);
        }
        else{
            if(f->left != NULL){
                q.push(f->left);
            }
            if(f->right != NULL){
                q.push(f->right);
            }
            temp.push_back(f->val);
        }
    }
    return ans;
    
}
