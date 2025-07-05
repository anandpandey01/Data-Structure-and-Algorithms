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
        Map<Node,Node> hs = new HashMap<>();
        Node curr = head, prev = null;
        Node newHead = null;
        while(curr!= null){
            Node newNode = new Node(curr.val);
            hs.put(curr,newNode);
            if(newHead == null){
                newHead = newNode;
                prev = newHead;
            }
            else{
                prev.next = newNode;
                prev      = newNode;
            }
            curr = curr.next;
        }
        // Fill Random Pointers
        curr = head;
        Node newCurr = newHead;

        while(curr!= null){
            if(curr.random == null){
                newCurr.random = null;
            }
            else{
                newCurr.random = hs.get(curr.random);
            }
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;

    }
}