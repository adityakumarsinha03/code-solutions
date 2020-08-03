/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class MaxPathSumAnyNode {
public:
    int maxPathSumUtil(TreeNode* root, int &res){
        if(root == NULL)
            return 0;
        
        int left = maxPathSumUtil(root->left, res);
        int right = maxPathSumUtil(root->right, res);
        
        int temp = max(root->val, (root->val) + max(left, right));
        int ans = max(temp, (root->val) + left + right);
        res = max(res, ans);
        
        return temp;
    }
    int maxPathSum(TreeNode* root) {
        int res = INT_MIN;
        maxPathSumUtil(root, res);
        return res;
    }
};