/*

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

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
ListNode* Solution::deleteDuplicates(ListNode* root){
    int len = 0;
    ListNode* curr = root;
    while(curr != NULL){
        len++;
        curr = curr->next;
    }
    if(len <= 1){
        return root;
    }
    ListNode* curr1 = root;
    ListNode* curr3 = new ListNode(0);
    ListNode* curr2 = curr3;
    for(int i = 0; i<len;){
        int x = 1;
        while(curr1!= NULL && curr1->next!=NULL && curr1->val==curr1->next->val){
            x++;
            curr1 = curr1->next;
        }
        if(x>1 && curr1->next != NULL){
            curr1 = curr1->next;
        }
        else if(x>1 && curr1->next == NULL){
            curr2->next = NULL;
        }
        else if(x == 1){
            curr2->next = curr1;
            curr2 = curr2->next;
            curr1 = curr1->next;
        }
        i = i+x;
    }
    return curr3->next;
}
