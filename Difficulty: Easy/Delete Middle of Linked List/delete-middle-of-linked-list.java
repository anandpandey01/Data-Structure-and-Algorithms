/*
class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        if(head == null || head.next == null) return null;
        
        Node slow = head; Node fast = head;
        Node slowPrev = null;
        while(fast!= null && fast.next!= null){
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slowPrev.next = slow.next;
        return head;
        
    }
}