/*

Given preorder and inorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input :
        Preorder : [1, 2, 3]
        Inorder  : [2, 1, 3]

Return :
            1
           / \
          2   3

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
TreeNode* constTreeUtil(vector<int>&pre, vector<int>&ino, int st, int en, int &pn){
    if(st>en){
        return NULL;
    }
    int x = pre[pn];
    TreeNode* root = new TreeNode(x);
    int ind;
    for(int i = st; i<=en; i++){
        if(x == ino[i]){
            ind = i;
            break;
        }
    }
    pn++;
    root->left = constTreeUtil(pre, ino, st, ind-1, pn);
    root->right = constTreeUtil(pre, ino, ind+1, en, pn);
    return root;
}
TreeNode* Solution::buildTree(vector<int> &preorder, vector<int> &inorder){
    
    int n = preorder.size();
    int pn = 0;
    return constTreeUtil(preorder, inorder, 0, n-1, pn);
}
