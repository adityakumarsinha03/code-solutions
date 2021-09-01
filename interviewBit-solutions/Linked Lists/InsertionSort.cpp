/*

Sort a linked list using insertion sort.

We have explained Insertion Sort at Slide 7 of Arrays

Insertion Sort Wiki has some details on Insertion Sort as well.

Example :

Input : 1 -> 3 -> 2

Return 1 -> 2 -> 3

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
ListNode* Solution::insertionSortList(ListNode* head){
    
    if(head == NULL){
        return head;
    }
    ListNode* curr = head;
    int y = 0;
    while(curr!=NULL){
        curr = curr->next;
        y++;
    }
    if(y == 1){
        return head;
    }
    
    curr = head;
    ListNode* temp1 = new ListNode(INT_MIN);
    temp1->next = head;
    head = temp1;
    // printList(head);    

    ListNode* curr2 = head;
    ListNode* curr1 = head->next;
    
    while(curr1 != NULL && curr2!=NULL){
        if(curr1->val < curr2->val){
            ListNode* temp2 = head;
            while(temp2!= NULL && temp2->next!=NULL && temp2->next->val<curr1->val){
                temp2 = temp2->next;
            }
            
            ListNode* temp3 = new ListNode(curr1->val);
            temp3->next = temp2->next;
            temp2->next = temp3;
            curr2->next = curr1->next; 
            curr1 = curr1->next;
        }
        else{
            curr2 = curr1;
            curr1 = curr1->next;
        }
    }
    // printList(head->next);
    return head->next;
}
