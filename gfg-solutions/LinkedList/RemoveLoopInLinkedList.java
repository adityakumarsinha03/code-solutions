// https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1

/*
class Node
{
    int data;
    Node next;
}
*/

class RemoveLoopInLinkedList {
    public static void removeLoop(Node head) {
        Node fast = head.next;
        Node slow = head;

        while (fast != null && fast.next != null && slow != null) {
            if (fast == slow)
                break;
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == slow) {
            slow = head;
            while (fast.next != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            fast.next = null;
        }
    }
}