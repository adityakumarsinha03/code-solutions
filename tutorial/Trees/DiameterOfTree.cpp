// https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1

int height(Node* root, int &res){
    if(root == NULL)
        return 0;
        
    int lh = height(root->left, res);
    int rh = height(root->right, res);
    
    res = max(res, 1 + lh + rh); // diameter = 1 + leftHeight + rightHeight
    return 1 + max(lh, rh); // used to find height of tree
}

int diameterMethod2(Node* root) {
    if(root == NULL)
        return 0;
    
    int res = INT_MIN;
    height(root, res);
    
    return res;
}

int diameterUtil(Node* root, int &res){
    // Base
    if(root == NULL)
        return 0;
    
    // Hypothesis
    int left = diameterUtil(root->left, res);
    int right = diameterUtil(root->right, res);
    
    // Induction
    int temp = 1 + max(left, right);
    int ans = max(temp, 1+left+right);
    res = max(res, ans);

    return temp;
}
int diameter(Node* root) {
    int res = INT_MIN;
    diameterUtil(root, res);
    
    return res;
}