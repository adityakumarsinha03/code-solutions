/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3331/
 * 
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;

        ListNode evenTemp = head.next;

        while ((odd != null && odd.next != null) || (even != null && even.next != null)) {
            if (even != null && even.next != null) {
                odd.next = even.next;
                odd = even.next;
            } else
                break;
            if (odd != null && odd.next != null) {
                even.next = odd.next;
                even = odd.next;
            } else
                break;
        }
        even.next = null;
        odd.next = evenTemp;
        return head;
    }
}