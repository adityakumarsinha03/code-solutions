/*

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

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
ListNode* Solution::deleteDuplicates(ListNode* head) {
    
    ListNode* curr = head;
    ListNode* temp = head;
    while(curr != NULL){
        
        while(curr->next != NULL && temp->val == curr->next->val){
            curr = curr->next;
        }
        temp->next = curr->next;
        temp = temp->next;
        curr = curr->next;
    }
    return head;
}
