// User function Template for Java

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
    Node divide(Node head) {
        // code here
        if(head == null || head.next == null) return head;
        Node curr = head;
        Node evenStart = null, oddStart = null;
        Node evenEnd = null,   oddEnd = null;
        
        while(curr!= null){
            if(curr.data % 2 == 0){
                if(evenStart == null){
                    evenStart = curr;
                    evenEnd = curr;
                }
                else{
                    evenEnd.next = curr;
                    evenEnd = evenEnd.next;
                }
            }
            else{
                if(oddStart == null){
                    oddStart = curr;
                    oddEnd = curr;
                }
                else{
                    oddEnd.next = curr;
                    oddEnd = oddEnd.next;
                }
            }
            curr = curr.next;
        }
        if(oddStart == null) return  evenStart;  // All Even
        if(evenStart == null) return oddStart;   // All Odd
        
        evenEnd.next = oddStart;
        oddEnd.next = null;
        return evenStart;
    }
}