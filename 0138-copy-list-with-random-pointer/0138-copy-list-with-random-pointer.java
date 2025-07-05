/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution { 
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node curr = head;
        // Creating Nodes in Between
        while(curr!= null){
            Node newNode = new Node(curr.val);
            Node nextNode = curr.next;
            curr.next = newNode;
            newNode.next = nextNode;
            curr = curr.next.next;
        }
        // Random Pointer Link
        curr = head;
        while(curr!= null && curr.next!= null){
            if(curr.random == null){
                curr.next.random = null;
            }
            else{
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        // Deleting in Between Nodes
        curr = head; Node newHead = head.next;
        Node newCurr = newHead;

        while(curr!= null && newCurr!= null){
            curr.next = (curr.next == null)? null: curr.next.next;
            newCurr.next = (newCurr.next == null)? null: newCurr.next.next;
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
}