/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node insertAtEnd(Node head, int x) {
        // code here
        Node temp = new Node(x);
        if(head == null) return temp;

        Node curr = head;
        while(curr.next!= null) curr = curr.next;
        curr.next = temp;
        return head;
    }
}