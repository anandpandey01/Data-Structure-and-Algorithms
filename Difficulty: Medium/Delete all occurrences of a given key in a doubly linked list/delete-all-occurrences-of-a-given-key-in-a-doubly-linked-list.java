// User function Template for Java

/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        if(head == null) return null;
        // Handle Head Case seprately
        while(head.data == x){
            head = head.next;
            if(head.prev != null) head.prev = null;
        }
        
        Node curr = head;
        while(curr != null){
            if(curr.data == x){
                curr.prev.next = curr.next;
                if(curr.next != null){
                    curr.next.prev = curr.prev;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}