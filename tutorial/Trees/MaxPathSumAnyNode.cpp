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
    int maxPathSumUtilMethod2(Node* root, int &sum){
        if(root == NULL)
            return 0;
        
        if(root->left == NULL && root->right == NULL)
            return root->data;
            
        // evaluate the max sum path in left subtree
        int ls = maxPathSumUtilMethod2(root->left, sum);
        
        // evaluate the max sum path in right subtree
        int rs = maxPathSumUtilMethod2(root->right, sum);
        
        if(root->left != NULL && root->right != NULL){
            // update sum with left + right subtree + root
            sum = max(sum, ls + rs + root->data);
            // return the maximum value evaluated so far, either left or right
            return max(ls, rs) + root->data;
        }
        else if(root->left == NULL) // if left is null, return right + root
            return rs + root->data;
        else
            return ls + root->data; // if right is null, return left + root
    }
    int maxPathSumMethod2(Node* root)
    {
        if(root == NULL)
            return 0;
        int res = INT_MIN;
        maxPathSumUtil(root, res);
        return res;
    }

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