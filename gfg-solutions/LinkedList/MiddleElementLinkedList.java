// https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1

class GFG
{
    // Function to find middle element a linked list
    int getMiddle(Node head)
   {
         int len = 0;
         
         Node curr = head;
         while(curr!=null){
             len++;
             curr = curr.next;
         }
         
         int x = 0;
         while(x<len/2){
             head = head.next;
             x++;
         }
         return head.data;
   }
}