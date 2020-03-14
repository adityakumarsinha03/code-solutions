/*

Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]

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
void pathsumUtil(TreeNode* root, int B, int sum, vector<vector<int> >&ans, vector<int>&temp){
    if(root == NULL){
        return;
    }
    sum = sum+root->val;
    temp.push_back(root->val);
    if(root->left==NULL && root->right==NULL){
        if(sum==B){
            ans.push_back(temp);
        }
        temp.pop_back();
        return;
    }
    pathsumUtil(root->left, B, sum, ans, temp);
    pathsumUtil(root->right, B, sum, ans, temp);
    temp.pop_back();
} 
vector<vector<int> > Solution::pathSum(TreeNode* root, int B){
    vector<vector<int> >ans;
    vector<int>temp;
    pathsumUtil(root, B, 0, ans, temp);
    return ans;
}
