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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr = list1;
        ListNode prev = null;
        for(int i=0; i<=b; i++){
            if(i == a-1){
                prev = curr;
            }
            curr = curr.next;
        }
        ListNode newCurr = list2;
        while(newCurr.next!=null){
            newCurr = newCurr.next;
        }
        prev.next = list2;
        newCurr.next = curr;
        return list1;

    }
}