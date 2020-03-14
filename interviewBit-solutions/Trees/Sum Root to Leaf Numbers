/*

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers % 1003.

Example :

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.

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
int pow1(int a){
    int ans = 1;
    for(int i = 0; i<a; i++){
        ans = (ans*10)%1003;
    }
    return ans;
} 
 
void sumUtil(TreeNode* root, int &tot, vector<int>&temp){
    if(root == NULL){
        return;
    }
    temp.push_back(root->val);
    if(root->left==NULL && root->right==NULL){
        int tempsum = 0;
        for(int i = 0; i<temp.size(); i++){
            int x1 = temp[i];
            int x2 = pow1(temp.size()-1-i)%1003;
            int x = (x1*x2)%1003;
            tempsum = (tempsum+x)%1003;
        }
        tot = (tot%1003 + tempsum%1003)%1003;
    }
    sumUtil(root->left, tot, temp);
    sumUtil(root->right, tot, temp);
    temp.pop_back();
} 
 
int Solution::sumNumbers(TreeNode* A) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details

    vector<int>temp;
    int tot = 0;
    sumUtil(A, tot, temp);
    return tot;
}
