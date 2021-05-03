/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3693/
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class PalindromeLinkedList {
    public ListNode reverseList(ListNode head){
        if(head==null || head.next==null){
           return head;
        }
        
        ListNode temp = null;
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        int n = 0;        
        ListNode curr = head;
        while(curr != null){
            n++;
            curr = curr.next;
        }
        int m = (n-1)/2;
        
        ListNode curr1 = head;
        while(m > 0){
            m--;
            curr1 = curr1.next;
        }
        
        ListNode curr2 = curr1.next;
        curr1.next = reverseList(curr2);

        curr = head;
        curr1 = curr1.next;
        
        while(curr != null && curr1 != null){
            if(curr.val != curr1.val)
                return false;
            curr = curr.next;
            curr1 = curr1.next;
        }
        return true;
    }
}