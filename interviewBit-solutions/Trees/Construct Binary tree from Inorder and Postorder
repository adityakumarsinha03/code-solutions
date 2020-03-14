/*

Given inorder and postorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input : 
        Inorder : [2, 1, 3]
        Postorder : [2, 3, 1]

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
TreeNode* constTreeUtil(vector<int>&ino, vector<int>&post, int st, int en, int &pn){
    if(st>en){
        return NULL;
    }
    int x = post[pn-1];
    TreeNode* root = new TreeNode(x);
    int ind;
    for(int i = st; i<=en; i++){
        if(ino[i] == x){
            ind = i;
            break;
        }
    }
    pn--;
    root->right = constTreeUtil(ino, post, ind+1, en, pn);
    root->left = constTreeUtil(ino, post, st, ind-1, pn);
    return root;
}
TreeNode* Solution::buildTree(vector<int> &inorder, vector<int> &postorder){
    
    int n = inorder.size();
    return constTreeUtil(inorder, postorder, 0, n-1, n);
}
