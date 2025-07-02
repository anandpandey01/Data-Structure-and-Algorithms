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
    // Function to insert a new node at given position in doubly linked list.
    Node addNode(Node head, int p, int x) {
        // Your code here
        Node temp = new Node(x);
        if(head==null) return temp;
        int position = 0;
        Node curr = head;
        while(position != p){
            curr = curr.next;
            position++;
        }
        if(curr.next == null){        // If at End
            curr.next = temp;
            temp.prev = curr;
            return head;
        }
        Node nextNode = curr.next;   
        
        curr.next= temp;
        temp.prev = curr;
        temp.next = nextNode;
        nextNode.prev = temp;
        return head;
    }
}