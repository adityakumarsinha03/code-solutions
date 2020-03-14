/*

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the 
 two subtrees of every node never differ by more than 1. 
Example :


Given A : 1 -> 2 -> 3
A height balanced BST  :

      2
    /   \
   1     3

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
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
TreeNode* BSTUtil(vector<int>&a, int st, int en){
    
    if(st>en){
        return NULL;
    }
    int mid = (st+en)/2;
    TreeNode* temp = new TreeNode(a[mid]);
    
    temp->left = BSTUtil(a, st, mid-1);
    temp->right = BSTUtil(a, mid+1, en);
    return temp;
}

/*TreeNode* BSTUtil(ListNode* head, int start, int end) {
	if (start > end)
		return NULL;

	// mid
	int mid = (start + end)/2;

	TreeNode* left = BSTUtil(head, start, mid - 1);
	TreeNode* root = new TreeNode(head->val);
// 	head = head->next;
	TreeNode* right = BSTUtil(head->next, mid + 1, end);

	root->left = left;
	root->right = right;
	return root;
}*/
/*ListNode* list;
TreeNode* BSTUtil(int len){

    if(len == 0){
        return NULL;
    }
    TreeNode* temp = new TreeNode(0);
    temp->left = BSTUtil(len/2);
    temp->val = list->val;
    list = list->next;
    
    temp->right = BSTUtil(len - (len/2) -1);
    return temp;
}*/
TreeNode* Solution::sortedListToBST(ListNode* head){
    
    if(head == NULL){
        return NULL;
    }
    // this->list = head;
    vector<int>a;
    while(head != NULL){
        a.push_back(head->val);
        head = head->next;
    }
    int n = a.size();
    /*int y = 0;
    while(curr != NULL){
        y++;
        curr = curr->next;
    }*/
    return BSTUtil(a, 0, n-1);
}
