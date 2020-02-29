// https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1

class ReverseLL
{
    // This function should reverse linked list and return
   // head of the modified linked list.
   Node reverseList(Node head)
   {
       if(head==null || head.next==null){
           return head;
       }
       Node curr = head;
       Node prev = null;
       Node temp = null;
       
       while(curr!=null){
           temp = curr.next;
           curr.next = prev;
           prev = curr;
           curr = temp;
       }
       return prev;
   }
}