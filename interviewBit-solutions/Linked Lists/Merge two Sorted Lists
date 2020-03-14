/*

Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

For example, given following linked lists :

  5 -> 8 -> 20 
  4 -> 11 -> 15
The merged list should be :

4 -> 5 -> 8 -> 11 -> 15 -> 20

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
ListNode* Solution::mergeTwoLists(ListNode* a, ListNode* b){
    
    ListNode* d = new ListNode(0);
    ListNode* c = d;
    ListNode* curr1 = a;
    ListNode* curr2 = b;
    
    while(curr1 != NULL && curr2 != NULL){
        if(curr1->val > curr2->val){
            c->next = new ListNode(curr2->val);
            c = c->next;
            curr2 = curr2->next;
        }
        else if(curr1->val < curr2->val){
            c->next = new ListNode(curr1->val);
            c = c->next;
            curr1 = curr1->next;
        }
        else if(curr1->val == curr2->val){
            c->next = new ListNode(curr1->val);
            c = c->next;
            c->next = new ListNode(curr2->val);
            c = c->next;
            curr1 = curr1->next;
            curr2 = curr2->next;
        }
    }
    while(curr1 != NULL){
        c->next = new ListNode(curr1->val);
        c = c->next;
        curr1 = curr1->next;
    }
    while(curr2 != NULL){
        c->next = new ListNode(curr2->val);
        c = c->next;
        curr2 = curr2->next;
    }
    return d->next;
}
