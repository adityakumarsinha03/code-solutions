/*

Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes: 
- Expected solution is linear in time and constant in space.

For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.

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
 
ListNode* reversel(ListNode* head){
    
    ListNode* next;
    ListNode* prev = NULL;
    ListNode* curr = head;
    while(curr!= NULL){
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }
    head = prev;
    return head;
}
int Solution::lPalin(ListNode* head){
    
    if(head == NULL){
        return 1;
    }
    int n = 0;
    ListNode* curr = head;
    while(curr != NULL){
        n++;
        curr = curr->next;
    }
    curr = head;
    ListNode* curr1;
    for(int i = 0; i<n/2; i++){
        curr1 = curr;
        curr = curr->next;
    }
    if(n%2 != 0){
        curr1 = curr;
        curr = curr->next;
    }
    ListNode* curr2 = reversel(curr);
    curr1->next = curr2;

    curr = head;
    ListNode* curr3 = head;
    for(int i = 0; i<n/2; i++){
        curr3 = curr3->next;
    }
    if(n%2 != 0){
        curr3 = curr3->next;
    }
    for(int i = 0; i<n/2; i++){
        if(curr->val != curr3->val){
            return 0;
        }
        else{
            curr = curr->next;
            curr3 = curr3->next;
        }
    }
    return 1;
}
