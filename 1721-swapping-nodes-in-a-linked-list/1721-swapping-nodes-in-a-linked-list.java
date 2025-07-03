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
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        int n = 1;
        while(curr.next!= null){
            n++;
            curr = curr.next;
        }

        int position = 1;
        ListNode currStart = head;
        while(position != k){
            position++;
            currStart = currStart.next;
        }
        ListNode currEnd = head;
        position = 1;
        while(position != n-k+1){
            position++;
            currEnd = currEnd.next;
        }
        int temp = currStart.val;
        currStart.val = currEnd.val;
        currEnd.val = temp;
        return head;
    }
}