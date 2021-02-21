// https://leetcode.com/problems/minimum-depth-of-binary-tree/

class Solution {
public:
    int minDepth(TreeNode* root) {
        if(root==NULL){
            return 0;
        }
        else {
            int lh=minDepth(root->left);
            int rh=minDepth(root->right);
            if(rh==0){
                return lh +1;
            }
            if(lh==0){
                return rh +1;
            }
            return min(lh,rh)+1;    
        }
    }
};
