/*

Given an inorder traversal of a cartesian tree, construct the tree.

 Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree. 
 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input : [1 2 3]

Return :   
          3
         /
        2
       /
      1

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
int dist(vector<int>a, int st, int en){
    
    int maxm = a[st];
    int maxmind = st;
    for(int i = st+1; i<=en; i++){
        if(a[i]>maxm){
            maxm = a[i];
            maxmind = i;
        }
    }
    return maxmind;
}

TreeNode* inord(vector<int>a, int st, int en){
    if(st>en){
        return NULL;
    }
    //int x = distance(a.begin(), max_element(a.begin()+st, a.begin()+en));
    int x = dist(a, st, en);
    TreeNode* root = new TreeNode(a[x]);
    
    if(st == en){
        return root;
    }
    root->left = inord(a, st, x-1);
    root->right = inord(a, x+1, en);
    return root;
} 
 
TreeNode* Solution::buildTree(vector<int> &a){
    
    int n = a.size();
    if(n == 0){
        return NULL;
    }
    TreeNode* root = inord(a, 0, n-1);
    return root;
}
