/*

Given a binary tree, print a vertical order traversal of it.

Example :
Given binary tree:

      6
    /   \
   3     7
  / \     \
 2   5     9
returns

[
    [2],
    [3],
    [6 5],
    [7],
    [9]
]

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
/*void vertiord(TreeNode* root, int dist, map<int, vector<int> >&m){
    
    if(root == NULL){
        return;
    }
    
    m[dist].push_back(root->val);
    
    vertiord(root->left, dist-1, m);
    vertiord(root->right, dist+1, m);
} */
 
vector<vector<int> > Solution::verticalOrderTraversal(TreeNode* root){
    vector<vector<int> >ans;
    vector<int>d;
    if(root == NULL){
        return ans;
    }
    else if(root->left == NULL && root->right == NULL){
        d.push_back(root->val);
        ans.push_back(d);
        return ans;
    }
    map<int, vector<int> >m;
    int dist = 0;
    
    queue<pair<TreeNode*, int> >q;
    q.push(make_pair(root, dist));
    while(!q.empty()){
        pair<TreeNode*, int> temp = q.front();
        q.pop();
        dist = temp.second;
        TreeNode* node = temp.first;
        
        m[dist].push_back(node->val);
        if(node->left != NULL){
            q.push(make_pair(node->left, dist-1));
        }
        if(node->right != NULL){
            q.push(make_pair(node->right, dist+1));
        }
    }
    
    for(auto it = m.begin(); it != m.end(); it++){
        ans.push_back(it->second);
    }
    return ans;
}
