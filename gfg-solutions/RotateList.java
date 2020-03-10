// https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1

/*
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
*/
class Rotate {
    
     /*  This function should rotate list counter-
    clockwise by k and return new head (if changed) */
    public Node rotate(Node head, int k) {
        
        int length = 0;
        Node currlen = head;
        
        while(currlen != null){
            currlen = currlen.next;
            length++;
        }
        
        if(k<1 || length<2){
            return head;
        }
        
        k = k%length;
        if(k<1){
            return head;
        }
        
        int len = 0;
        Node curr = head;
        
        while(len<k-1){
            curr = curr.next;
            len++;
        }
        Node curr2 = curr.next;
        curr.next = null;
        
        Node curr3 = curr2;
        while(curr3.next!=null){
            curr3 = curr3.next;
        }
        curr3.next = head;
        
        return curr2;
    }
}
