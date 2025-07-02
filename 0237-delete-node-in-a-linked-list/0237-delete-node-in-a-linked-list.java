/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        
        ListNode prevNode = null;
        ListNode curr = node;
        while(curr.next!= null){
            curr.val = curr.next.val;
            prevNode = curr;
            curr = curr.next;     
        }
        prevNode.next = null;
    }
}