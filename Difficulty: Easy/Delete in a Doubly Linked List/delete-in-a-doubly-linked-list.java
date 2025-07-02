/*

Definition for doubly Link List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        // code here
        if(x == 1) {
            head.next.prev = null;
            return head.next;
        }
        int position = 1;
        
        Node curr = head;
        while(position!= x){
            curr = curr.next;
            position++;
        }
        if(curr.next == null){      // Last Node
            curr.prev.next = null;
            curr.prev = null;
            return head;
        }
        
        Node prevNode = curr.prev;
        
        prevNode.next = curr.next;
        curr.next.prev = prevNode;
        return head;
    }
}