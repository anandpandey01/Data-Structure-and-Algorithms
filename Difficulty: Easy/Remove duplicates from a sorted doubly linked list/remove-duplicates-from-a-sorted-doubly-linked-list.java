// User function Template for Java

class Solution {
    Node removeDuplicates(Node head) {
        // Code Here.
        if(head == null || head.next == null) return head;
        Node curr = head;
        
        while(curr!= null && curr.next!= null){
            if(curr.data == curr.next.data){
                Node nextNode = curr.next;
                curr.next = nextNode.next;
                if(nextNode.next != null) nextNode.next.prev = curr;
            }
            else{
                curr = curr.next;
            }   
        }
        return head;
    }
}