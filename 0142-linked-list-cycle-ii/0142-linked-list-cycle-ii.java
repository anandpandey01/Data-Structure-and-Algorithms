/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head; ListNode fast = head;
        while(fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }                               // 2 Possibilities Either slow = fast or fast = null
        if(slow != fast) return null;      // No cycle

        ListNode p = head;
        while(slow != p){
            p = p.next;
            slow = slow.next;
        }
        return p;
    }
}