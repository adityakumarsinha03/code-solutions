/*

Reverse a linked list using recursion.

Example :
Given 1->2->3->4->5->NULL,

return 5->4->3->2->1->NULL.

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
ListNode* head;
ListNode* reverseLL(ListNode* a){
    if(a->next == NULL){
        head = a;
        return head;
    }
    reverseLL(a->next);
    ListNode* b = a->next;
    b->next = a;
    a->next = NULL;
    return head;
}

ListNode* Solution::reverseList(ListNode* a){
    
    if(a == NULL){
        return a;    
    }
    return reverseLL(a);
    
}
