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
        Node curr = head;
        if(curr == null) return temp;
        while(curr.next!= null){
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }
}