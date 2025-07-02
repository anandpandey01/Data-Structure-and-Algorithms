/*
class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        // Your code here
        if(head == null || head.next ==null) return head;
        DLLNode prevNode = null, curr = head;
        while(curr!= null){
            prevNode = curr.prev;
            curr.prev = curr.next;
            curr.next = prevNode;
            curr = curr.prev;
        }
        return prevNode.prev;
    }
}