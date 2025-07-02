/*
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        if(head == null || head.next == null) return 0;
        Node slow = head;  Node fast = head;
        Node prevSlow = null;
        while(fast!= null && fast.next!= null){
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(slow!= fast) return 0;
        
        Node p = head;
        while(p!= slow){
            p = p.next;
            slow= slow.next;
        }
        int nodes =1;
        while(p.next!= slow){
            p = p.next;
            nodes++;
        }
        return nodes;
        
    }
}