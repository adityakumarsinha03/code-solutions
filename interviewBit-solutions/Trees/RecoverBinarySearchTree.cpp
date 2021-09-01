/*

Two elements of a binary search tree (BST) are swapped by mistake.
Tell us the 2 values swapping which the tree will be restored.

 Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution? 
Example :


Input : 
         1
        / \
       2   3

Output : 
       [1, 2]

Explanation : Swapping 1 and 2 will change the BST to be 
         2
        / \
       1   3
which is a valid BST

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
void recurInorder(TreeNode* root, TreeNode* &prevN, TreeNode* &firstN, TreeNode* &lastN){
    if(root == NULL){
        return;
    }
    recurInorder(root->left, prevN, firstN, lastN);
        
    if(prevN!=NULL){
        if(prevN->val > root->val){
            if(firstN == NULL){
                firstN = prevN;
            }
            lastN = root;
        }
    }
    prevN = root;
    recurInorder(root->right, prevN, firstN, lastN);
}
vector<int> Solution::recoverTree(TreeNode* root){
    TreeNode* prevN = NULL;
    TreeNode* firstN = NULL;
    TreeNode* lastN = NULL;
    
    vector<int>ans;
    if(root == NULL){
        return ans;
    }
    recurInorder(root, prevN, firstN, lastN);
    
    if(firstN != NULL && lastN != NULL){
        ans.push_back(firstN->val);
        ans.push_back(lastN->val);
        sort(ans.begin(), ans.end());
    }
    return ans;
}
