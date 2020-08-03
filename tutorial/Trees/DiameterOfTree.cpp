// https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1

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