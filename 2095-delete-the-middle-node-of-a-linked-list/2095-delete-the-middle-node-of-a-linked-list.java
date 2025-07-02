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
    public ListNode deleteMiddle(ListNode head) {
        ListNode curr = head;
        int n = 1;
        while(curr.next!= null){
            curr = curr.next;
            n++;
        }
        if(n == 1) return null;
        int middle = n/2;
        int position = 0;                       // 0 based indexing
        ListNode prevNode = null, currNode = head;
        while(position!= middle){
            prevNode = currNode;
            currNode = currNode.next;
            position++;
        }
        if(currNode.next == null)  prevNode.next = null;
        else prevNode.next = currNode.next;
        return head;

    }
}