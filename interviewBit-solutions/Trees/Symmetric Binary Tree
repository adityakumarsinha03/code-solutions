/*

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Example :

    1
   / \
  2   2
 / \ / \
3  4 4  3
The above binary tree is symmetric. 
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

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
int symmUtil(TreeNode* rootl, TreeNode* rootr){
    
    if(rootl==NULL && rootr==NULL){
        return 1;
    }
    if(rootl==NULL || rootr==NULL){
        return 0;
    }
    if(rootl->val != rootr->val){
        return 0;
    }
    return symmUtil(rootl->left, rootr->right)&&
            symmUtil(rootl->right, rootr->left);
}
int Solution::isSymmetric(TreeNode* root){
    
    if(root==NULL){
        return 1;
    }
    
    return symmUtil(root->left, root->right);
    
 // Iterative Approach:
 // ===========================
    /*TreeNode* curr = root;
    
    queue<TreeNode*>ql1, ql2, qr1, qr2;
    ql1.push(root);
    qr1.push(root);
    while(!ql1.empty() || !ql2.empty() || !qr1.empty() || !qr2.empty()){
        while(!ql1.empty() && !qr1.empty()){
            TreeNode* curr1 = ql1.front();
            ql1.pop();
            TreeNode* curr2 = qr1.front();
            qr1.pop();
            if(curr1->val != curr2->val){
                return 0;
            }
            if(curr1->left !=NULL){
                ql2.push(curr1->left);
                if(curr2->right !=NULL){
                    qr2.push(curr2->right);
                }
                else{
                    return 0;
                }
            }
            
            if(curr1->right !=NULL){
                ql2.push(curr1->right);
                if(curr2->left !=NULL){
                    qr2.push(curr2->left);
                }
                else{
                    return 0;
                }
            }
        }
        
        while(!ql2.empty() && !qr2.empty()){
            TreeNode* curr1 = ql2.front();
            ql2.pop();
            TreeNode* curr2 = qr2.front();
            qr2.pop();
            if(curr1->val != curr2->val){
                return 0;
            }
            if(curr1->left !=NULL){
                ql1.push(curr1->left);
                if(curr2->right !=NULL){
                    qr1.push(curr2->right);
                }
                else{
                    return 0;
                }
            }
            
            if(curr1->right !=NULL){
                ql1.push(curr1->right);
                if(curr2->left !=NULL){
                    qr1.push(curr2->left);
                }
                else{
                    return 0;
                }
            }
        }
    }
    return 1;*/
}
