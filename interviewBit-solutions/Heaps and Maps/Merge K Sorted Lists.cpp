/*

Merge k sorted linked lists and return it as one sorted list.

Example :

1 -> 10 -> 20
4 -> 11 -> 13
3 -> 8 -> 9
will result in

1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20

*/

Solution:

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
struct compare {
    bool operator()(ListNode* a, ListNode* b){
        return a->val > b->val;
    }
};
 
ListNode* Solution::mergeKLists(vector<ListNode*> &a){
    
    int n = a.size();
    ListNode* finalNode = new ListNode(0);
    ListNode* currfinal = finalNode;
    priority_queue<ListNode*, vector<ListNode*>, compare> pq;
    
    for(int i = 0; i<n; i++){
        if(a[i] != NULL){
            pq.push(a[i]);
        }
    }
    while(!pq.empty()){
        ListNode* temp = pq.top();
        pq.pop();
        if(temp->next != NULL){
            pq.push(temp->next);
        }
        currfinal->next = temp;
        currfinal = currfinal->next;
    }
    return finalNode->next;
}
