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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int n = 1;
        ListNode curr = head;
        while(curr.next != null){
            curr = curr.next;
            n++;
        }
        k = k % n; 
        if (k == 0) return head;        // No rotation needed
        int pos = n - k;
        ListNode prev = head;
        while(pos > 1){
            pos--;
            prev = prev.next;
        }
        ListNode result = prev.next;
        prev.next = null;
        curr.next = head;
        return result;
    }
}