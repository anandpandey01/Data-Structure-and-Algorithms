/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int pos = 0;
        while(pos < k){
            if(curr == null) return head;   // K node doesn't exist
            curr = curr.next;
            pos++;
        }
        ListNode prevNode = reverseKGroup(curr, k);
        curr = head; pos = 0;
        while(pos < k){
            ListNode nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = nextNode;
            pos++;
        } 
        return prevNode;
    }
}