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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        // Find the middle pointer
        ListNode slow = head, fast = head,prevNode = null;
        while(fast!= null && fast.next!= null){
            prevNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse from middle
        ListNode prev = null, next = null, curr = slow;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
        }
        prevNode.next = null;    // Break the link
        curr = head;
        while(curr!= null && prev!= null){
            if(curr.val!= prev.val) return false;
            curr = curr.next;
            prev = prev.next;
        }
        return true;
    }
}