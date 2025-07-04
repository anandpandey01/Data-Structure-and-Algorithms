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
 // Similar to slow fast Instead of moving 1 and 2 think respect to K
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode p1 = null, p2 = null;
        ListNode curr = head;
        while(curr != null){
            if(p2 != null){
                p2 = p2.next;
            }
            k--;
            if(k == 0){
                p1 = curr;
                p2 = head;    // Activate;
            }
            curr = curr.next;
        }
        int temp = p1.val;
        p1.val = p2.val;
        p2.val = temp;

        return head;
    }
}