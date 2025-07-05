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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       int L = 1;
       ListNode curr = head;
        while(curr.next!= null){
            curr = curr.next;
            L++;
        }
        if(L == n){
            return head.next;
        }

        int position = L-n; curr = head;
        ListNode prev = null;
        while(position-- >0){
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        return head;


    }
}